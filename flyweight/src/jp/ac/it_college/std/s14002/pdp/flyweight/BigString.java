package jp.ac.it_college.std.s14002.pdp.flyweight;

/**
 * Created by s14002 on 15/06/17.
 */
public class BigString {
    private BigChar[] bigchars;

    public BigString(String string){
        bigchars =new BigChar[string.length()];
        BigCharFactory factory =BigCharFactory.getInstance();
        for (int i = 0;i<bigchars.length;i++) {
            bigchars[i] = factory.getBigchar(string.charAt(i));
        }
    }
    public void print() {
        for (int i = 0;i<bigchars.length;i++) {
            bigchars[i].print();
        }
    }
}
