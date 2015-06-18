package jp.ac.it_college.std.s14002.pdp.interpreter;


/**
 * Created by s14002 on 15/06/18.
 */
public class PrimitiveCommandNode extends Node {
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException(name + "is undefined");
        }
    }
    public String toString() {
        return name;
    }
}
