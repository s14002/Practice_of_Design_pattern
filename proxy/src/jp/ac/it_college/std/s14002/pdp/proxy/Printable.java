package jp.ac.it_college.std.s14002.pdp.proxy;

/**
 * Created by s14002 on 15/06/18.
 */
public interface Printable {
    void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}
