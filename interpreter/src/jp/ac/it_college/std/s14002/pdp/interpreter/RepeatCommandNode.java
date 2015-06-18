package jp.ac.it_college.std.s14002.pdp.interpreter;

/**
 * Created by s14002 on 15/06/18.
 */
public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public String toString() {
        return "[repeat " + number+ " " + commandListNode + "]";
    }
}
