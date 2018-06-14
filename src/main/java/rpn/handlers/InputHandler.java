package rpn.handlers;

import rpn.EventDispatcher;
import rpn.events.IEvent;
import rpn.events.InputEvent;
import rpn.events.TokenEvent;

public class InputHandler implements IHandlers {

    private EventDispatcher eventDispatcher;

    public InputHandler(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void execEvent(IEvent iEvent) {
        if(iEvent.getType() != InputEvent.class){
            throw new UnsupportedOperationException("L'Event ne correspond pas a ce Handler");
        }

        InputEvent event = (InputEvent) iEvent;

        for (String s : event.getText().split("[ ]+")) {
            eventDispatcher.dispatch(new TokenEvent(s));
        }

        // EOE => End Of Expression
        eventDispatcher.dispatch(new TokenEvent("EOE"));
    }
}
