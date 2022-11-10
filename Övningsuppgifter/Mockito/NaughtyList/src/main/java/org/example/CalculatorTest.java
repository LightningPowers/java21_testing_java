package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void additionTest(){
        int expected = 6;
        int actual = calculator.addition(2,4);
        assertEquals(expected, actual);
    }
}
