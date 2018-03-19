package rpn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by LEBEAU Mike
 * ESGI - 4 AL 1
 * on 18/03/2018
 */
public class TestError {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void TestWithAnEmptyInput(){
        expectedEx.expect(UnsupportedOperationException.class);
        expectedEx.expectMessage("Please check your input, only numbers, '+', '-', '*' and '/' are accepted.");
        RPNCalculator.RpnCalculate("");
    }

    @Test
    public void TestWithOneFogottenOperator(){
        expectedEx.expect(UnsupportedOperationException.class);
        expectedEx.expectMessage("Please check your input, We think you forgot one opertor or one number.");
        RPNCalculator.RpnCalculate("5 2 3 +");
    }


    @Test
    public void TestDivisionByZero(){
        expectedEx.expect(ArithmeticException.class);
        expectedEx.expectMessage("Divide by zero is denied !");
        RPNCalculator.RpnCalculate("5 0 /");
    }

}
