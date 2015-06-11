package jp.ac.it_college.std.s14002.pdp.decorator;

/**
 * Created by s14002 on 15/06/11.
 */
public class SideBorder extends Border {
    private char borderChar;
    public SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;

    }
    @Override
    public int getColumn() {
        return 1 + display.getColumn() + 1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
