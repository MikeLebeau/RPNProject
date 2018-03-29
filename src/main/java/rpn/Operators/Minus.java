package rpn.Operators;

import rpn.IOperator;

/**
 * Created by Miky on 25/03/2018.
 */
public class Minus implements IOperator {

    @Override
    public long calculate(long num1, long num2) {
        return num1 - num2;
    }
}
