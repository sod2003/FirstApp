package com.example.myfirstapp;

import junit.framework.TestCase;

public class CalculatorTest2 extends TestCase {
    public void testMult() {
        assertEquals(15, Calculator.mult(5, 3));
    }

    public void testDiv() {
        assertEquals(2, Calculator.div(20, 10));
    }
}
