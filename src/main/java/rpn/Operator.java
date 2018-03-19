package rpn;

/**
 * Created by Miky on 04/03/2018.
 */
public enum Operator {

    Plus("+"),
    Minus("-"),
    Multiply("*"),
    Divide("/");

    final private String value;

    Operator(String c) {
        this.value = c;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "value='" + value + '\'' +
                '}';
    }

    public static Operator findByValue(String s){
        for (Operator operator : values()) {
            if(operator.getValue().equals(s)){
                return operator;
            }
        }
        return null;
    }
}
