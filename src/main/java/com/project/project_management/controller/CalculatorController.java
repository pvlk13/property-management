package com.project.project_management.controller;

import com.project.project_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        return num1+num2;
    }
    @GetMapping("/sub")
    public Double sub(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        if(num1>num2){
            return num1-num2;
        }
        else return -(num2-num1);
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double>responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
