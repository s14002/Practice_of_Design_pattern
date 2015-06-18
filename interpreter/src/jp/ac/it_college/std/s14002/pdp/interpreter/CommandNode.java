package jp.ac.it_college.std.s14002.pdp.interpreter;

/**
 * Created by s14002 on 15/06/18.
 */
public class CommandNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            node = new  RepeatCommandNode();
            node.parse(context);
        }else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }
    public String toString() {
        return node.toString();
    }
}
