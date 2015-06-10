package jp.ac.it_college.std.s14002.pdp.af.factory;

/**
 * Created by s14002 on 15/06/10.
 */
public abstract class Item {
    protected String caption;
    public Item(String caption) {
        this.caption = caption;
    }
    public abstract String makeHTML();
}
