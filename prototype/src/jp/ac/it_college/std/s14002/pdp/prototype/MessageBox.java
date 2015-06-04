package jp.ac.it_college.std.s14002.pdp.prototype;

import jp.ac.it_college.std.s14002.pdp.prototype.framework.Product;

import java.io.UnsupportedEncodingException;

/**
 * Created by s14002 on 15/06/04.
 */
public class MessageBox implements Product {
    private char decochar;
    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    public void use(String s) {
        int length = 0;
        try {
            length = s.getBytes("MS932").length;
        } catch (UnsupportedEncodingException e) {
            System.out.println("サポートされていない文字コードです");
            System.exit(1);
        }

        for (int i = 0; i < length; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);

        for (int i = 0; i< length+4;i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("cloneがサポートされていないクラスです");
            System.err.println(e.getStackTrace());
        }
        return p;
    }

}
