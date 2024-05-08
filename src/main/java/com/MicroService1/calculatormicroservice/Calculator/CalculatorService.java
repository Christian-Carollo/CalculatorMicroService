package com.MicroService1.calculatormicroservice.Calculator;

import com.MicroService1.calculatormicroservice.RandomNumberGenerator.RandomNumberGeneratorService;
import com.MicroService1.calculatormicroservice.RandomOperatorGenerator.RandomOperatorGeneratorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class CalculatorService implements ICalculatorService{

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CalculatorService.class);

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final RandomOperatorGeneratorService randomOperatorGeneratorService;
    @Autowired
    public CalculatorService(RandomNumberGeneratorService randomNumberGeneratorService, RandomOperatorGeneratorService randomOperatorGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.randomOperatorGeneratorService = randomOperatorGeneratorService;
    }


    @Override
    public int performOperation(int op1, int op2, char operator) {
        try {
            return switch (operator) {
                case '+' -> op1 + op2;
                case '-' -> op1 - op2;
                case '*' -> op1 * op2;
                case '/' -> {
                    if (op2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    yield op1 / op2;
                }
                default -> throw new IllegalArgumentException("Invalid Operator");
            };
        } catch (IllegalArgumentException | ArithmeticException e) {
            logger.info("Error performing calculation: {}");
            throw new IllegalArgumentException("Error performing calculation", e);
        }
    }
}
