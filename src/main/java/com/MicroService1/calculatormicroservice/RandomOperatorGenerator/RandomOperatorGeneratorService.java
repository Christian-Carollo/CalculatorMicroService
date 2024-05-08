package com.MicroService1.calculatormicroservice.RandomOperatorGenerator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomOperatorGeneratorService implements IRandomOperatorGeneratorService{

    private static final char[] OPERATORS = {'+', '-', '*', '/'};

    @Override
    public char generateOperator() {
        try {
            return OPERATORS[new Random().nextInt(OPERATORS.length)];
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error generating random operator", e);
        }
    }
}
