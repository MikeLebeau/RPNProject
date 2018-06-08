package rpn;

import rpn.events.InputEvent;
import rpn.events.ReturnEvent;
import rpn.events.TokenEvent;
import rpn.handlers.InputHandler;
import rpn.handlers.ReturnHandler;
import rpn.handlers.TokenHandler;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    static long evaluate(String expression) {
//        return new RPNCalculator().rpnCalculate(expression);
        EventDispatcher dispatcher = new EventDispatcher();

        InputHandler inputHandler = new InputHandler(dispatcher);
        ReturnHandler returnHandler = new ReturnHandler(dispatcher);
        TokenHandler tokenHandler = new TokenHandler(dispatcher);

        dispatcher.registerHandler(InputEvent.class, inputHandler);
        dispatcher.registerHandler(ReturnEvent.class, returnHandler);
        dispatcher.registerHandler(TokenEvent.class, tokenHandler);

        dispatcher.dispatch(new InputEvent(expression));

        return 0L;
    }
}
