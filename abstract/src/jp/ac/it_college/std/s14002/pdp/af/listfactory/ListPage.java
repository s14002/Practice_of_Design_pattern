package jp.ac.it_college.std.s14002.pdp.af.listfactory;

import jp.ac.it_college.std.s14002.pdp.af.factory.Item;
import jp.ac.it_college.std.s14002.pdp.af.factory.Page;

import java.util.Iterator;

/**
 * Created by s14002 on 15/06/10.
 */
public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n")
                .append("<body>\n")
                .append("<h1>" + title + "</h1>\n")
                .append("<ul>\n");
        Iterator it = content.iterator();
        while (it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>'n")
                .append("<hr><address>" + author + "</address>")
                .append("</body><html>\n");
        return buffer.toString();
    }
}
