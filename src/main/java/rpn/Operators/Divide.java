package rpn.Operators;

import rpn.IOperator;

/**
 * Created by Miky on 25/03/2018.
 */
public class Divide implements IOperator {

    @Override
    public long calculate(long num1, long num2) {
        if(num2 == 0){
            throw new UnsupportedOperationException("Divide by zero is denied !");
        }

        return num1 / num2;
    }
}
