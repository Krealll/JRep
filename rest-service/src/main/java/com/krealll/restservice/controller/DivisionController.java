package com.krealll.restservice.controller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.krealll.restservice.application.exceptions.BadArgumentsException;
import com.krealll.restservice.application.exceptions.MethodNotSupportedException;
import com.krealll.restservice.application.exceptions.ServerException;
import com.krealll.restservice.model.Division;
import com.krealll.restservice.model.DivisionDT;
import com.krealll.restservice.service.Counter;
import com.krealll.restservice.service.DivisionService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DivisionController {

    @Autowired
    DivisionService service;

    @GetMapping("/divide")
    public ResponseEntity<?> division(@RequestParam(value = "dividend",required = true) int ddd,
                                      @RequestParam(value = "divider",required = true) int ddr)
            throws BadArgumentsException, ServerException {
        return new ResponseEntity<>(service.formResponse(ddd,ddr), HttpStatus.OK);
    }

    @GetMapping("/GetCounter")
    public ResponseEntity<?> getRequestCounter(){return new ResponseEntity(service.getRequestCounter(),HttpStatus.OK);}

    @GetMapping()
    public String greeting(){
        return "<h1>Greeting, stranger</h1>";
    }

    @PostMapping(value = "/postJson")
    public ResponseEntity<?> postJson(@RequestBody String string)
            throws JsonParseException, JsonMappingException, JSONException {
        Division division =  service.parseJson(string);
        return new ResponseEntity<>(service.formResponse(division.getDividend(),division.getDivider()),HttpStatus.OK);
    }

    @PostMapping(value = "/postJsonBulk",consumes = "application/json")
    public ResponseEntity<?> postJsonBulk(@RequestBody String s)
            throws JsonParseException, JsonMappingException, JSONException {
        DivisionDT divisionDT = service.parseJsonBulk(s);
        return new ResponseEntity<>(service.formResponse(divisionDT.getDivisions()),HttpStatus.OK);
    }



}