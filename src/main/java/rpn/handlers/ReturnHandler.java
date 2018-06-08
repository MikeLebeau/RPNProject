package rpn.handlers;

import rpn.EventDispatcher;
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
        if(iEvent.getType() != InputEvent.class){
            throw new UnsupportedOperationException("L'Event ne correspond pas a ce Handler");
        }

        ReturnEvent event = (ReturnEvent) iEvent;
        System.out.println("4 - Je suis dans le onEvent de ReturnHandler");
        System.out.println("  - iEvent type : " + iEvent.getClass());
        System.out.println("  - event type : " + event.getText() );
    }
}
