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
        return new RPNCalculator().rpnCalculate(expression);
    }
}
