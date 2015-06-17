package jp.ac.it_college.std.s14002.pdp.state;

/**
 * Created by s14002 on 15/06/17.
 */
public interface Context {
    void setClock(int hour);
    void changeState(State state);
    void callSecurityCenter(String msg);
    void recordLog(String msg);
}
