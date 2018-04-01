package rpn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by LEBEAU Mike
 * ESGI - 4 AL 1
 * on 18/03/2018
 */
public class TestError {

    @ParameterizedTest
    @ValueSource(strings = {"", "5;2;5;4"})
    public void TestWithAnEmptyInput(String exp){
        Throwable throwable = assertThrows(UnsupportedOperationException.class, () -> new RPNCalculator().rpnCalculate(exp));
        assertEquals("Please check your input, only numbers, '+', '-', '*' and '/' are accepted.", throwable.getMessage());
    }

    @Test
    public void TestDivisionByZero(){
        Throwable throwable = assertThrows(ArithmeticException.class, () -> new RPNCalculator().rpnCalculate("5 0 /"));
        assertEquals("Divide by zero is denied !", throwable.getMessage());
    }

    /**
     * If they are no operators, it return the last num
     */
    @Test
    public void TestWithNoOperator(){
        long result = new RPNCalculator().rpnCalculate("5 2 5 4");
        assertEquals(4L, result);
    }

    @Test
    public void TestWithInvalidSeparator(){
        long result = new RPNCalculator().rpnCalculate("5     2 5 4");
        assertEquals(4L, result);
    }
}
