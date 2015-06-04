package jp.ac.it_college.std.s14002.pdp.factory.singleton;

/**
 * Created by s14002 on 15/06/04.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("インスタンスを生成しました");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
