package rpn;

import org.apache.commons.lang.math.NumberUtils;

import java.util.Stack;

/**
 * Created by Miky on 04/03/2018.
 */
public class RPNCalculator {

    public static long RpnCalculate(String exp){

        Stack<Integer> numStack = new Stack<>();
        Stack<Operator> opStack = new Stack<>();
        long result = 0;

        for (String s : exp.split(" ")) {
            if(NumberUtils.isNumber(s)){
                numStack.push(Integer.parseInt(s));
            }else if(Operator.findByValue(s) != null){
                if(numStack.size() == 1){
                    return numStack.pop();
                }

                int num2 = numStack.pop();
                int num1 = numStack.pop();

                numStack.push(calculate(Operator.findByValue(s), num1, num2));
            }else{
                throw new UnsupportedOperationException("Please check your input, only numbers, '+', '-', '*' and '/' are accepted.");
            }
        }

        if(opStack.size() != numStack.size()-1){
            throw new UnsupportedOperationException("Please check your input, We think you forgot one opertor or one number.");
        }

        return numStack.pop();
    }

    private static int calculate(Operator op, int num1, int num2){
        switch (op){
            case Plus:
                return num1 + num2;
            case Minus:
                return num1 - num2;
            case Multiply:
                return num1 * num2;
            case Divide:
                if(num2 == 0){
                    throw new ArithmeticException("Divide by zero is denied !");
                }
                return num1 / num2;
            default:
                // By default, but already catched in first for block...
                throw new UnsupportedOperationException("Unknown operator/character.");
        }
    }
}
