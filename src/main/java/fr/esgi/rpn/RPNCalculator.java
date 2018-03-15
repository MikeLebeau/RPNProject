package fr.esgi.rpn;

import org.apache.commons.lang.math.NumberUtils;

import java.util.Stack;

/**
 * Created by Miky on 04/03/2018.
 */
public class RPNCalculator {

    public static String RpnCalculate(String exp){

        Stack<Integer> numStack = new Stack<>();
        Stack<Operator> opStack = new Stack<>();

        for (String s : exp.split(" ")) {
            if(NumberUtils.isNumber(s)){
                numStack.push(Integer.parseInt(s));
            }else if(Operator.findByValue(s) != null){
                opStack.push(Operator.findByValue(s));
            }else{
                throw new UnsupportedOperationException("Please check your input, only numbers, '+', '-', '*' and '/' are accepted.");
            }
        }

        // To put the operator in good order
        opStack = (Stack<Operator>)reverseStack(opStack);
        //numStack = (Stack<Integer>)reverseStack(numStack);

        System.out.println("opStack : " + opStack);
        System.out.println("numStack : " + numStack);

        do {
            int num2 = numStack.pop();
            int num1 = numStack.pop();

            System.out.println("num1 = " + num1);
            System.out.println("num2 = " + num2);

            numStack.push(calculate(opStack.pop(), num1, num2));

        }while(!opStack.isEmpty());

        if(numStack.size() == 1){
            return String.valueOf(numStack.pop());
        }else{
            String result = "";
            for (Integer integer : numStack) {
                result += integer;
            }
            return result;
        }
    }

    private static int calculate(Operator op, int num1, int num2){
        switch (op){
            case Plus:
                System.out.println(num1 + " + " + num2);
                return num1 + num2;
            case Minus:
                System.out.println(num1 + " - " + num2);
                return num1 - num2;
            case Multiply:
                System.out.println(num1 + " * " + num2);
                return num1 * num2;
            case Divide:
                throw new UnsupportedOperationException("Not implemented yet.");
            default:
                throw new UnsupportedOperationException("Unknown operator.");
        }
    }

    private static Stack<?> reverseStack(Stack<?> stack){
        Stack<Object> result = new Stack<>();
        int count = stack.size();

        for (int i = 0; i < count; i++) {
            result.push(stack.pop());
        }

        return result;
    }

}
