package jp.ac.it_college.std.s14002.pdp.adapter;

/**
 * Created by s14002 on 15/06/03.
 */
public class PrintBanner2 extends Print2 {
    private Banner banner;

    public PrintBanner2(String string) {
        this.banner = new Banner(string);
    }

    public void printWeak() {
        banner.showWithParen();
    }
    public void printStrong() {
        banner.showWithAster();
    }
}
