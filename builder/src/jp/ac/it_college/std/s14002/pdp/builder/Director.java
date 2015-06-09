package jp.ac.it_college.std.s14002.pdp.builder;

/**
 * Created by s14002 on 15/06/09.
 */
public class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    public void construct() {
        builder.makeTitel("Greeting")
                .makeString("朝から昼にかけて");
        builder.makeItems(new String[]{
                "おはようございます",
                "こんにちは",
        });
        builder.makeString("夜に")
                .makeItems(new String[]{
                "こんにちは",
                "おやすみなさい",
                "さようなら",
        });
        builder.close();
    }
}
