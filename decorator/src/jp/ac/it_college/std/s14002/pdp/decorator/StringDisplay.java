package jp.ac.it_college.std.s14002.pdp.decorator;

/**
 * Created by s14002 on 15/06/11.
 */
public class StringDisplay extends Display{
    private String string;
    public StringDisplay(String string) {
        this.string = string;
    }
    public int getColumn() {
        return  string.getBytes().length;
    }
    public int getRows() {
        return  1;
    }
    public String getRowText(int row) {
        if (row == 0) {
            return string;
        } else {
            return  null;
        }
    }
}
