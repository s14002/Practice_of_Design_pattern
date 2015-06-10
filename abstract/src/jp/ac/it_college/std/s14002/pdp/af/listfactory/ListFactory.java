package jp.ac.it_college.std.s14002.pdp.af.listfactory;

import jp.ac.it_college.std.s14002.pdp.af.factory.Factory;
import jp.ac.it_college.std.s14002.pdp.af.factory.Link;
import jp.ac.it_college.std.s14002.pdp.af.factory.Page;
import jp.ac.it_college.std.s14002.pdp.af.factory.Tray;

/**
 * Created by s14002 on 15/06/10.
 */
public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }

}
