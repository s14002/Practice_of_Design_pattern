package jp.ac.it_college.std.s14002.pdp.command.command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by s14002 on 15/06/18.
 */
public class MacroCommand implements Command {
    public Deque<Command> commands  = new ArrayDeque<>();

    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    public void undo() {
         if (!commands.isEmpty()){
            commands.pop();
        }
    }
    public void clear() {
        commands.clear();
    }
}
