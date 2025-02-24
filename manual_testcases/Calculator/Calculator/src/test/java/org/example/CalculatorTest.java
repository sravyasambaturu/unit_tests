package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void divide() {
        double result = calculator.divide(10, 2);
        assertEquals(5, result, 0);
    }

    // Testing summing an array {1, 2, 3, 4}, expecting 10 as the result
    @Test
    public void sum() {
        double[] arr = {1, 2, 3, 4};
        double result = calculator.sum(arr);
        assertEquals(10, result, 0);
    }

    @Test
    public void subtract() {
        double[] arr = {10, 2, 3};
        double result = calculator.subtract(arr);
        assertEquals(5, result, 0);
    }

    @Test
    public void multiplication() {
        double[] arr = {2, 3, 4};
        double result = calculator.Multiplication(arr);
        assertEquals(24, result, 0);
    }

    @Test
    public void squareRoot() {
        double result = calculator.squareRoot(16);
        assertEquals(4, result, 0);
    }

    @Test
    public void modulo() {
        double result = calculator.moduloOfTwoNum(10, 3);
        assertEquals(1, result, 0);
    }

    @Test
    public void average() {
        double[] arr = {1, 2, 3, 4};
        double result = calculator.Average(arr);
        assertEquals(2.5, result, 0);
    }

    @Test
    public void factorial() {
        int result = calculator.factorial(5);
        assertEquals(120, result);
    }
//    calculating 0!, expecting 1
    @Test
    public void factorialZero() {
        int result = calculator.factorial(0);
        assertEquals(1, result);
    }
    // calculating factorial of a negative number (-5), expecting 0 (since factorial is undefined for negatives)
    @Test
    public void factorialNegative() {
        int result = calculator.factorial(-5);
        assertEquals(0, result);
    }
//    calculating the square root of -16, expecting Double.MIN_VALUE (since it's not a real number)
    @Test
    public void squareRootNegativeNumber() {
        double result = calculator.squareRoot(-16);
        assertEquals(Double.MIN_VALUE, result, 0);
    }

    @Test
    public void divideByZero() {
        double result = calculator.divide(10, 0);
        assertEquals(Double.MIN_VALUE, result, 0);
    }

    @Test
    public void moduloByZero() {
        double result = calculator.moduloOfTwoNum(10, 0);
        assertEquals(Double.MIN_VALUE, result, 0);
    }
}
