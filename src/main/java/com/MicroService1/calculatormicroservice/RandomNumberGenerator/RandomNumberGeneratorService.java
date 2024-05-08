package com.MicroService1.calculatormicroservice.RandomNumberGenerator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNumberGeneratorService implements IRandomNumberGeneratorService {
    @Override
    public int generateNumber() {
        try {
            return new Random().nextInt(100);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error generating random number", e);
        }
    }
}
