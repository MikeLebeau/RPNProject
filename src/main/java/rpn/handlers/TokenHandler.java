package rpn.handlers;

import org.apache.commons.lang.math.NumberUtils;
import rpn.EventDispatcher;
import rpn.IOperator;
import rpn.events.IEvent;
import rpn.events.ReturnEvent;
import rpn.events.TokenEvent;
import rpn.operators.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TokenHandler implements IHandlers {

    private EventDispatcher eventDispatcher;
    private Stack<Long> numStack = new Stack<>();
    private Map<String, IOperator> map;

    private Map<String, IOperator> setAllOperators(){
        map = new HashMap<>();

        map.put("+", new Plus());
        map.put("-", new Minus());
        map.put("*", new Multiply());
        map.put("/", new Divide());
        map.put("%", new Modulo());

        return map;
    }

    public TokenHandler(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
        setAllOperators();
    }

    @Override
    public void execEvent(IEvent iEvent) {
        if(iEvent.getType() != TokenEvent.class){
            throw new UnsupportedOperationException("L'Event ne correspond pas a ce Handler");
        }

        TokenEvent event = (TokenEvent) iEvent;
        String token = event.getToken();

        if(NumberUtils.isNumber(token)){
            numStack.push(Long.parseLong(event.getToken()));
        }else if(map.get(token) != null){
            if(numStack.size() == 1){
                eventDispatcher.dispatch(new ReturnEvent(numStack.pop()));
            }

            long num2 = numStack.pop();
            long num1 = numStack.pop();

            numStack.push(map.get(token).calculate(num1, num2));
        }

        eventDispatcher.dispatch(new ReturnEvent(numStack.pop()));
    }
}
