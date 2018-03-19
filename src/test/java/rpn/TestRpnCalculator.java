package rpn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Miky on 04/03/2018.
 */
public class TestRpnCalculator {

    // -----------------------------------------------------------
    // ---------------------- Basic Tests ----------------------
    // -----------------------------------------------------------

    /**
     * Basic addition test
     * Input : 20 5 +
     * Should return 25
     */
    @Test
    public void TestBasicAddition(){
        long result = RPNCalculator.RpnCalculate("20 5 +");
        assertEquals(25L, result);
    }

    /**
     * Basic substraction test
     * Input : 20 5 -
     * Should return 15
     */
    @Test
    public void TestBasicSubstraction(){
        long result = RPNCalculator.RpnCalculate("20 5 -");
        assertEquals(15L, result);
    }

    /**
     * Basic multiplication test
     * Input : 20 5 *
     * Should return 100
     */
    @Test
    public void TestBasicMultiplication(){
        long result = RPNCalculator.RpnCalculate("20 5 *");
        assertEquals(100L, result);
    }

    /**
     * Basic division test
     * Input : 20 5 /
     * Should return 4
     */
    @Test
    public void TestBasicDivision(){
        long result = RPNCalculator.RpnCalculate("20 5 /");
        assertEquals(4L, result);
    }

    // -----------------------------------------------------------
    // ---------------------- Complex Tests ----------------------
    // -----------------------------------------------------------

    @Test
    public void TestComplexe00(){
        long result = RPNCalculator.RpnCalculate("5 2 3 + -");
        assertEquals(0L, result);
    }

    @Test
    public void TestComplexe01(){
        long result = RPNCalculator.RpnCalculate("2 3 + 5 -");
        assertEquals(0L, result);
    }

    @Test
    public void TestComplexe02(){
        long result = RPNCalculator.RpnCalculate("4 2 + 3 -");
        assertEquals(3L, result);
    }

    @Test
    public void TestComplexe03(){
        long result = RPNCalculator.RpnCalculate("1 2 + 4 * 3 +");
        assertEquals(15L, result);
    }

    @Test
    public void TestComplexe04(){
        long result = RPNCalculator.RpnCalculate("3 4 1 2 + * +");
        assertEquals(15L, result);
    }

    @Test
    public void TestComplexe05(){
        long result = RPNCalculator.RpnCalculate("-1 -2 +");
        assertEquals(-3L, result);
    }

    @Test
    public void TestComplexe06(){
        long result = RPNCalculator.RpnCalculate("3 5 8 * 7 + *");
        assertEquals(141L, result);
    }

    @Test
    public void TestComplexe07(){
        long result = RPNCalculator.RpnCalculate("3 7 5 8 * + *");
        assertEquals(141L, result);
    }

}
