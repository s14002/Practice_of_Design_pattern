package jp.ac.it_college.std.s14002.pdp.responsibility;

/**
 * Created by s14002 on 15/06/16.
 */
public class SpecialSupport extends Support {
    private int number;
    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
