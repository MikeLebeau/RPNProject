package rpn;

/**
 * Created by raphi on 04/06/2018.
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach( this);
    }
    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
