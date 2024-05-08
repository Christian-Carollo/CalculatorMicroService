package com.MicroService1.calculatormicroservice.RandomOperatorGenerator;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/random")
public class RandomOperatorGeneratorController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(RandomOperatorGeneratorController.class);

    private final RandomOperatorGeneratorService randomOperatorGeneratorService;
    @Autowired
    public RandomOperatorGeneratorController(RandomOperatorGeneratorService randomOperatorGeneratorService) {
        this.randomOperatorGeneratorService = randomOperatorGeneratorService;
    }

    @GetMapping("/operator")
    public char generatorRandomOperator(){
        try {
            return randomOperatorGeneratorService.generateOperator();
        } catch (IllegalArgumentException e) {
            logger.info("Error generating random operator");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error generating random operator", e);
        }
    }
}
