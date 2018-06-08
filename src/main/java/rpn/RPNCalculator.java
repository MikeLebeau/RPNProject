package rpn;

import org.apache.commons.lang.math.NumberUtils;
import rpn.operators.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Miky on 04/03/2018.
 */
public class RPNCalculator {

    private Map<String, IOperator> map;

//    private Map<String, IOperator> setAllOperators(){
//        map = new HashMap<>();
//
//        map.put("+", new Plus());
//        map.put("-", new Minus());
//        map.put("*", new Multiply());
//        map.put("/", new Divide());
//        map.put("%", new Modulo());
//
//        return map;
//    }


    public long rpnCalculate(String exp){

//        setAllOperators();

        Stack<Long> numStack = new Stack<>();

        for (String s : exp.split("[ ]+")) {
            if(NumberUtils.isNumber(s)){
                numStack.push(Long.parseLong(s));
            }else if(map.get(s) != null){
                if(numStack.size() == 1){
                    return numStack.pop();
                }

                long num2 = numStack.pop();
                long num1 = numStack.pop();

                numStack.push(map.get(s).calculate(num1, num2));
            }else{
                throw new UnsupportedOperationException("Please check your input, only numbers, '+', '-', '*', '/' and '%' are accepted.");
            }
        }

        return numStack.pop();
    }
}
