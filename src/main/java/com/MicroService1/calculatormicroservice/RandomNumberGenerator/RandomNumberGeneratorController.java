package com.MicroService1.calculatormicroservice.RandomNumberGenerator;

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
public class RandomNumberGeneratorController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(RandomNumberGeneratorController.class);
    private final RandomNumberGeneratorService randomNumberGeneratorService;
    @Autowired
    public RandomNumberGeneratorController(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    @GetMapping("/number")
    public int generatorRandomNumber(){
        try{

            return randomNumberGeneratorService.generateNumber();
        }catch (Exception e){
            logger.info("Error generating random number");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error generating random number", e);
        }
    }
}
