package rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by LEBEAU Mike
 * ESGI - 4 AL 1
 * on 18/03/2018
 */
public class TestError {

    @Test
    public void TestWithAnEmptyInput(){
        Throwable throwable = assertThrows(UnsupportedOperationException.class, () -> RPNCalculator.RpnCalculate(""));
        assertEquals("Please check your input, only numbers, '+', '-', '*' and '/' are accepted.", throwable.getMessage());
    }

    @Test
    public void TestDivisionByZero(){
        Throwable throwable = assertThrows(ArithmeticException.class, () -> RPNCalculator.RpnCalculate("5 0 /"));
        assertEquals("Divide by zero is denied !", throwable.getMessage());
    }

    /**
     * If they are no operators, it return the last num
     */
    @Test
    public void TestWithNoOperator(){
        long result = RPNCalculator.RpnCalculate("5 2 5 4");
        assertEquals(4L, result);
    }
}
