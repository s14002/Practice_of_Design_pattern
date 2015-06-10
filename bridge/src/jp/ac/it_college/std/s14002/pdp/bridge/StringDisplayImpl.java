package jp.ac.it_college.std.s14002.pdp.bridge;

import java.io.UnsupportedEncodingException;

/**
 * Created by s14002 on 15/06/10.
 */
public class StringDisplayImpl extends DisplayImpl{
    private String string;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        try {
            this.width = string.getBytes("MS932").length;
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
            this.width = string.getBytes().length;
        }
    }

    public void rawOpen() {
        printLine();
    }
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }
    public void rawClose() {
        printLine();
    }
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
