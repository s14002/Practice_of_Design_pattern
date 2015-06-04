package jp.ac.it_college.std.s14002.pdp.template;

/**
 * Created by s14002 on 15/06/04.
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display() {
        open();
        for (int i = 0; i < 5;i++) {
            print();
        }
        close();
    }
}
