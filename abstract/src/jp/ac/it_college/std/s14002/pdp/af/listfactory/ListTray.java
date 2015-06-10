package jp.ac.it_college.std.s14002.pdp.af.listfactory;

import jp.ac.it_college.std.s14002.pdp.af.factory.Item;
import jp.ac.it_college.std.s14002.pdp.af.factory.Tray;

import java.util.Iterator;

/**
 * Created by s14002 on 15/06/10.
 */
public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n")
                .append(caption + "\n")
                .append("<ul>\n");
        Iterator it = tray.iterator();
        while (it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n")
                .append("</ul>\n");
        return buffer.toString();
    }
}
