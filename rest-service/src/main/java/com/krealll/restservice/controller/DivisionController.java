package com.krealll.restservice.controller;


import com.krealll.restservice.application.exceptions.BadArgumentsException;
import com.krealll.restservice.application.exceptions.MethodNotSupportedException;
import com.krealll.restservice.application.exceptions.ServerException;
import com.krealll.restservice.service.DivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DivisionController {

    DivisionService service = new DivisionService();
    @GetMapping("/divide")
    public ResponseEntity<?> division(@RequestParam(value = "dividend",required = true) int ddd,
                                      @RequestParam(value = "divider",required = true) int ddr)
            throws BadArgumentsException, ServerException {
        return new ResponseEntity<>(service.formResponse(ddd,ddr), HttpStatus.OK);
    }

    @GetMapping()
    public String greeting(){
        return "<h1>Greeting, stranger</h1>";
    }

    @PostMapping(value = "/post")
    public ResponseEntity<?> divisionPost()
            throws MethodNotSupportedException {
        MethodNotSupportedException e = new MethodNotSupportedException("Method not supported yet");
        throw e;
    }

}