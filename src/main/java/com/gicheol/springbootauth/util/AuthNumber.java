package com.gicheol.springbootauth.util;

import java.util.Random;

public class AuthNumber {
    public static int generateAuthNumber() {
        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());
        return generator.nextInt(1000000) % 1000000;
    }
}
