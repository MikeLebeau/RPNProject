package fr.esgi.rpn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Miky on 04/03/2018.
 */
public class TestRpnCalculator {

    /**
     * Basic test
     * Input : 20 5 +
     * Should return "25"
     */
    @Test
    public void TestBasic(){
        String result = RPNCalculator.RpnCalculate("20 5 +");
        assertEquals("25", result);
    }

    @Test
    public void TestBasicBis(){
        String result = RPNCalculator.RpnCalculate("5 2 3 + -");
        assertEquals("0", result);
    }

    @Test
    public void TestBasicBisBis(){
        String result = RPNCalculator.RpnCalculate("4 2 + 3 -");
        assertEquals("3", result);
    }

}
