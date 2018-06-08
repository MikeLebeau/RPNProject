package rpn.events;

public interface IEvent {

    Class<? extends IEvent> getType();

}
