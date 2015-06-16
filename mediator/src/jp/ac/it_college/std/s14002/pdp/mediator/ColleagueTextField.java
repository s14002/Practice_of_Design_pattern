package jp.ac.it_college.std.s14002.pdp.mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * Created by s14002 on 15/06/16.
 */
public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;
    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;

    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);

    }

    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();

    }
}
