package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivisionController {

    Division result;
    DivisionService service = new DivisionService();
    @GetMapping("/divide")
    public ResponseEntity<?> maximum(@RequestParam(value = "dividend", defaultValue = "1") String ddd,
                                     @RequestParam(value = "divider", defaultValue = "1") String ddr)
    
    {
        Integer dividend = Integer.valueOf(ddd),divider = Integer.valueOf(ddr);
        result= service.divide(dividend,divider);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public String greeting(){
        return "<h1>Greeting, stranger</h1>";
    }


}