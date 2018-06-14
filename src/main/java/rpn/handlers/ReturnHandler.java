package rpn.handlers;

import rpn.CLI;
import rpn.EventDispatcher;
import rpn.RPNCalculator;
import rpn.events.IEvent;
import rpn.events.InputEvent;
import rpn.events.ReturnEvent;

public class ReturnHandler implements IHandlers{

    private EventDispatcher eventDispatcher;

    public ReturnHandler(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void execEvent(IEvent iEvent) {
        if(iEvent.getType() != ReturnEvent.class){
            throw new UnsupportedOperationException("L'Event ne correspond pas a ce Handler");
        }

        ReturnEvent event = (ReturnEvent) iEvent;
        System.out.println("Le resultat : " + event.getResult());
        RPNCalculator.result = event.getResult();
    }
}
