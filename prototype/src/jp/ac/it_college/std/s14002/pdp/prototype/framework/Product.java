package jp.ac.it_college.std.s14002.pdp.prototype.framework;

/**
 * Created by s14002 on 15/06/04.
 */
public interface Product extends Cloneable{
    void use(String s);
    Product createClone();
}
