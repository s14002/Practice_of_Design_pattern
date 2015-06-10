package jp.ac.it_college.std.s14002.pdp.af.factory;

import jp.ac.it_college.std.s14002.pdp.af.factory.Item;

/**
 * Created by s14002 on 15/06/10.
 */
public abstract class Link extends Item {
    protected String url;
    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}