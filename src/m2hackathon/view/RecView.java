package m2hackathon.view;

import m2hackathon.mainMulticast.MainMulticastSocket;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.*;

public class RecView extends JFrame{
    JLabel la = new JLabel();
    JLabel la2 = new JLabel();
    JLabel la3 = new JLabel();

    public RecView(ArrayList<String> receiveArray)
    {
        super("recView");
        ArrayList<String> r = new ArrayList<>();
        r = receiveArray;

        LocalTime now = LocalTime.now();

        la.setText("message :" + r.get(0));
        la2.setText("보낸 사람 : " + r.get(1));
        la3.setText("보낸 시간 : " + now);

        setSize(300,300);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(la);
        c.add(la2);
        c.add(la3);
        setVisible(true);
    }
}