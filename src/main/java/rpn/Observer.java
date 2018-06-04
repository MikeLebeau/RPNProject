package rpn;

import rpn.Subject;

/**
 * Created by raphi on 04/06/2018.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
