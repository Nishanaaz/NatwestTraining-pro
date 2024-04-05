package com.example.test;

import org.example.Calculation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationTest {
   Calculation calculation = new Calculation();
    @Test
    public void addTest(){
        assertEquals(3,calculation.add(1,2));
    }
}
