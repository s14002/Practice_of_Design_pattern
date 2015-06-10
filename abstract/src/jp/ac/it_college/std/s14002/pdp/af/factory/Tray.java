package jp.ac.it_college.std.s14002.pdp.af.factory;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;

/**
 * Created by s14002 on 15/06/10.
 */
public abstract class Tray extends Item {
    protected ArrayList<Link> tray = new ArrayList<>();
    protected Tray(String caption) {
        super(caption);
    }
    public void add(Link item) {
        tray.add(item);
    }
}
