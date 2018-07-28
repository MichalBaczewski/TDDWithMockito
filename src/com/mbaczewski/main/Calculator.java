package com.mbaczewski.main;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int parse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Niepoprawny numer");
        }
    }

}
