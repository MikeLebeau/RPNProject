package rpn.events;

public class ReturnEvent implements IEvent{

    private Long result;

    public ReturnEvent(Long result) {
        this.result = result;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    @Override
    public Class<? extends IEvent> getType() {
        return getClass();
    }
}
