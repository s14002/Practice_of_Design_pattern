package jp.ac.it_college.std.s14002.pdp.adapter;

/**
 * Created by s14002 on 15/06/03.
 */
public class PrintBanner extends Banner implements Print{
    public PrintBanner(String string) {
        super(string);
    }
    public void printWeak() {
        showWithParen();
    }
    public void printStrong() {
        showWithAster();
    }
}
