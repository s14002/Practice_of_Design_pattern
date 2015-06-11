package jp.ac.it_college.std.s14002.pdp.strategy;

/**
 * Created by s14002 on 15/06/10.
 */
public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
