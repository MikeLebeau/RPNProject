package rpn;

import rpn.events.IEvent;
import rpn.handlers.IHandlers;

import java.util.HashMap;
import java.util.Map;

public class EventDispatcher{

    private Map<Class<? extends IEvent>, IHandlers> handlers;

    public EventDispatcher() {
        handlers = new HashMap<>();
    }

    public void registerHandler(Class<? extends IEvent> iEvent, IHandlers iHandlers){
        handlers.put(iEvent, iHandlers);
    }

    public void dispatch(IEvent event){
        if(event.getClass() == null){
            throw new UnsupportedOperationException("Il n'y a pas de Handler pour cet Event");
        }

        handlers.get(event.getClass()).execEvent(event);
    }
}
