package jp.ac.it_college.std.s14002.pdp.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by s14002 on 15/06/09.
 */
public class HTMLBuilder extends Builder {
    private String filename;
    private PrintWriter writer;

    @Override
    public Builder makeTitel(String title) {
        filename = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head></body>");
        writer.println("<h1>" + title + "</h1>");
        return this;
    }

    @Override
    public Builder makeString(String str) {
        writer.println("<p>" + str + "</p>");
        return this;
    }

    @Override
    public Builder makeItems(String[] items) {
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
        return this;
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }
    public String getResult() {
        return filename;
    }
}
