package com.example.myfirstapp;

import static org.junit.Assert.assertThrows;

import junit.framework.TestCase;

public class CalculatorTest2 extends TestCase {
    public void testMult() {
        assertEquals(15, Calculator.mult(5, 3));
    }

    public void testDiv() {
        assertEquals(2, Calculator.div(20, 10));
    }

    public void testDiv2() { assertThrows(ArithmeticException.class,
            () -> { Calculator.div(1, 0);});
    }
}
