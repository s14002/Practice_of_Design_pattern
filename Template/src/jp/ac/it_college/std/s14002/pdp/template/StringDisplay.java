package jp.ac.it_college.std.s14002.pdp.template;

import java.io.UnsupportedEncodingException;

/**
 * Created by s14002 on 15/06/04.
 */
public class StringDisplay extends AbstractDisplay {
    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        try {
            this.width = string.getBytes("MS932").length;
        } catch (UnsupportedEncodingException e) {
            System.out.println("未対応の文字コードらしいです");
            System.exit(1);
        }
        System.out.println("width" + width);
    }
    public void open() {
        printLine();
    }
    public void print() {
        System.out.println("|" + string + "|");
    }
    public void close() {
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
