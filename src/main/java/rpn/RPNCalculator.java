package rpn;

import org.apache.commons.lang.math.NumberUtils;
import rpn.events.InputEvent;
import rpn.events.ReturnEvent;
import rpn.events.TokenEvent;
import rpn.handlers.InputHandler;
import rpn.handlers.ReturnHandler;
import rpn.handlers.TokenHandler;
import rpn.operators.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Miky on 04/03/2018.
 */
public class RPNCalculator {

    private Map<String, IOperator> map;

    //TODO Trouver une meilleure facon de retourner le resultat
    public static Long result;

    public long rpnCalculate(String exp){
        EventDispatcher dispatcher = new EventDispatcher();

        InputHandler inputHandler = new InputHandler(dispatcher);
        ReturnHandler returnHandler = new ReturnHandler(dispatcher);
        TokenHandler tokenHandler = new TokenHandler(dispatcher);

        dispatcher.registerHandler(InputEvent.class, inputHandler);
        dispatcher.registerHandler(ReturnEvent.class, returnHandler);
        dispatcher.registerHandler(TokenEvent.class, tokenHandler);

        dispatcher.dispatch(new InputEvent(exp));

        return result;
    }

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

    /**
     * Deprecated due to the Event Driven TP
     * @param exp
     * @return
     */
    @Deprecated
    public long rpnCalculateOld(String exp){

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
