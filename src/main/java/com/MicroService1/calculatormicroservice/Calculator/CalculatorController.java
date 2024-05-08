package com.MicroService1.calculatormicroservice.Calculator;

import com.MicroService1.calculatormicroservice.RandomNumberGenerator.RandomNumberGeneratorService;
import com.MicroService1.calculatormicroservice.RandomOperatorGenerator.RandomOperatorGeneratorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CalculatorController.class);


    private final CalculatorService calculatorService;
    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final RandomOperatorGeneratorService randomOperatorGeneratorService;
    @Autowired
    public CalculatorController(CalculatorService calculatorService, RandomNumberGeneratorService randomNumberGeneratorService, RandomOperatorGeneratorService randomOperatorGeneratorService) {
        this.calculatorService = calculatorService;
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.randomOperatorGeneratorService = randomOperatorGeneratorService;
    }

    @GetMapping("/add")
    public int add(){
        try {
            int op1 = randomNumberGeneratorService.generateNumber();
            int op2 = randomNumberGeneratorService.generateNumber();
            char operator = randomOperatorGeneratorService.generateOperator();
            return calculatorService.performOperation(op1, op2, operator);
        } catch (IllegalArgumentException e){
            logger.info("Error Calculator ");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error Calculator", e);
        }

    }

}
