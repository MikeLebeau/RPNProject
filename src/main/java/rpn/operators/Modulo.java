package rpn.operators;

import rpn.IOperator;

public class Modulo implements IOperator {
    @Override
    public long calculate(long num1, long num2) {
        return num1%num2;
    }
}
