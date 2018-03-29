package rpn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Miky on 04/03/2018.
 */
public class TestRpnCalculator {

    // -----------------------------------------------------------
    // ---------------------- Basic Tests ----------------------
    // -----------------------------------------------------------

    @ParameterizedTest
    @CsvSource({
            "'20 5 +', 25",
            "'20 5 -', 15",
            "'20 5 *', 100",
            "'20 5 /', 4"})
    public void TestBasic(String exp, long res){
        long result = new RPNCalculator().rpnCalculate(exp);
        assertEquals(res, result);
    }

    // -----------------------------------------------------------
    // ---------------------- Complex Tests ----------------------
    // -----------------------------------------------------------

    @ParameterizedTest
    @CsvSource({
            "'5 2 3 + -', 0",
            "'2 3 + 5 -', 0",
            "'4 2 + 3 -', 3",
            "'1 2 + 4 * 3 +', 15",
            "'3 4 1 2 + * +', 15",
            "'-1 -2 +', -3",
            "'3 5 8 * 7 + *', 141",
            "'3 7 5 8 * + *', 141"
    })
    public void TestComplex(String exp, long res){
        long result = new RPNCalculator().rpnCalculate(exp);
        assertEquals(res, result);
    }
}
