package jp.ac.it_college.std.s14002.pdp.state;

import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by s14002 on 15/06/17.
 */
public class SafeFrame extends Frame implements ActionListener,Context {
    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10,60);
    private Button buttonUse = new Button("金庫使用");
    private Button buttonAlarm = new Button("非常ベル");
    private Button buttonPhone = new Button("通常通話");
    private Button buttonExit = new Button("終了");

    private State state = DayState.getInstance();

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        //textClock配置
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        //textScreen配置
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        //パネルにボタン格納
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);
        pack();
        show();

        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse){
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() ==buttonPhone) {
            state.doPhone(this);
        } else if (e.getSource() ==buttonExit) {
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }
    public void setClock(int hour) {
        String clockstring = "現在時刻は";
        if (hour < 10) {
            clockstring += "0" + hour + ":00";
        } else {
            clockstring += hour+":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }
    public void changeState(State state) {
        System.out.println(this.state + "から" + state + "へ状態が変化しました");
        this.state = state;
    }
    public void callSecurityCenter(String msg) {
        textScreen.append("call!"+msg+"\n");
    }
    public void recordLog(String msg) {
        textScreen.append("record..."+msg+"\n");
    }
}
