package rpn.events;

public class TokenEvent implements IEvent {

    private String token;

    public TokenEvent(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Class<? extends IEvent> getType() {
        return getClass();

    }
}
