package jp.ac.it_college.std.s14002.pdp.decorator;

/**
 * Created by s14002 on 15/06/11.
 */
public abstract class Display {
    public abstract int getColumn();
    public abstract int getRows();
    public abstract  String getRowText(int row);
    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }

}
