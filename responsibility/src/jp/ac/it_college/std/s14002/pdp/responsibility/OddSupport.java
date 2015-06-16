package jp.ac.it_college.std.s14002.pdp.responsibility;

/**
 * Created by s14002 on 15/06/16.
 */
public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }
}
