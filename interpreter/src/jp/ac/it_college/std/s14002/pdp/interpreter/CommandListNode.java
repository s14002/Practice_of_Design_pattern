package jp.ac.it_college.std.s14002.pdp.interpreter;

import java.util.ArrayList;

/**
 * Created by s14002 on 15/06/18.
 */
// <command list> :: = <command>* end
public class CommandListNode extends Node {
    private ArrayList list = new ArrayList();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end' ");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }
    public String toString() {
        return list.toString();
    }
}
