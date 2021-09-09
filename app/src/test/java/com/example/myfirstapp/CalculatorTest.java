package com.example.myfirstapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        assertEquals(4, Calculator.add(1, 3));
    }

    public void testSubtract() {
        assertEquals(1, Calculator.subtract(3, 2));
    }
}