package com.krealll.restservice.service;

import com.krealll.restservice.application.handlers.MethodNotSupportedExceptionHandler;
import com.krealll.restservice.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionService  {

    private static Logger logger = LogManager.getLogger(MethodNotSupportedExceptionHandler.class);
    @Autowired
    DivisionCacher<DivisionResult> cacher;
    @Autowired
    Counter RequestCounter;
    @Autowired
    DivisionResultComparator comparator;


    public DivisionResult getDivisionResult(int dividend, int divider){
        return new DivisionResult(calculateQuotient(dividend,divider), calculateReminder(dividend,divider));
    }

    public DivisionResult formResponse(int dividend, int divider){
        Validator.validate(dividend,divider);
        RequestCounter.increment();
        logger.info("Successful division:dividend {} divider {}",dividend,divider);
        return cacheData(dividend,divider);
    }

    private DivisionResult cacheData(int dividend, int divider){
        DivisionResult result = cacher.contains(dividend,divider)?
                cacher.get(dividend,divider):
                cacher.put(dividend,divider,getDivisionResult(dividend,divider));
        return result;
    }

    public int calculateQuotient(int dividend, int divider){
        return dividend/divider;
    }

    public int calculateReminder(int dividend, int divider){
        return dividend%divider;
    }

    public int getRequestCounter() {
        return RequestCounter.getCounter();
    }

    public Division parseJson(String string) throws JSONException {
        JSONObject jo = new JSONObject(string);
        return new Division((int)jo.getJSONObject("division").get("dividend"),
                (int)jo.getJSONObject("division").get("divider"));
    }


    public DivisionResultDT formResponse(List<Division> divisions) {
        final long unique = divisions.stream().distinct().count(),
                total = divisions.stream().count();
        List<Division> validationList =divisions.stream().distinct().filter(d->Validator.validateDivision(d)).collect(Collectors.toList());
        List<DivisionResult> resultList = validationList.stream().filter(d->Validator.validateDivision(d)).map(d->{
            return formResponse(d.getDividend(),d.getDivider());
        }).collect(Collectors.toList());
        return new DivisionResultDT(resultList.stream().max(comparator).get().getQuotient(),total,unique,
                unique-validationList.stream().count(),resultList);
    }

    public DivisionDT parseJsonBulk(String s) throws JSONException {
        DivisionDT divisionDT = new DivisionDT();
        List<Division>resultList=new ArrayList<Division>();
        JSONArray list = new JSONArray();
        JSONObject jo = new JSONObject(s), temp;
        list= jo.getJSONArray("divisions");
        int ddd,ddr;
        for (int i = 0; i<list.length();i++){
            temp =list.getJSONObject(i);
            ddd= (int) temp.get("dividend");
            ddr=(int)temp.get("divider");
            resultList.add(new Division(ddd,ddr));
        }
        divisionDT.setDivisions(resultList);
        return divisionDT;
    }
}
