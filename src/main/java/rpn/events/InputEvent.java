package rpn.events;

public class InputEvent implements IEvent {

    private String text;

    public InputEvent(String text) {
        this.text = "InputEvent : " + text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Class<? extends IEvent> getType() {
        return getClass();
    }

}
