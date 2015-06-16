package jp.ac.it_college.std.s14002.pdp.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by s14002 on 15/06/16.
 */
public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textpass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));

        createColleagues();

        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password"));
        add(textpass);
        add(buttonOk);
        add(buttonCancel);

        colleagueChanged();

        pack();
        show();
    }
    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, true);
        textUser = new ColleagueTextField("", 10);
        textpass = new ColleagueTextField("", 10);
        textpass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textpass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textpass.addTextListener(textpass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void colleagueChanged() {
        if (textUser.getText().length() > 0) {
            textpass.setColleagueEnabled(true);
         if (textpass.getText().length() > 0) {
            buttonOk.setColleagueEnabled(true);
        } else {
            buttonOk.setColleagueEnabled(false);
            }
        } else {
        textpass.setColleagueEnabled(false);
        buttonOk.setColleagueEnabled(false);
        }
    }
}
