package com.example.myfirstapp;

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        if(b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero!");
        }
    }
}
