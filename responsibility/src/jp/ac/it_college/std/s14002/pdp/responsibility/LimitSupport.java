package jp.ac.it_college.std.s14002.pdp.responsibility;

/**
 * Created by s14002 on 15/06/16.
 */
public class LimitSupport extends Support {
    private int limit;
    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit;
    }
}
