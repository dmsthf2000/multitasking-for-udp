package m2hackathon.view;

import m2hackathon.mainMulticast.MainMulticastSocket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.*;

public class RecView extends JFrame{
    JLabel la = new JLabel();
    JLabel la2 = new JLabel();
    JLabel la3 = new JLabel();
    JLabel la4 = new JLabel();

    public RecView(ArrayList<String> receiveArray)
    {
        super("recView");
        ArrayList<String> r = new ArrayList<>();
        r = receiveArray;

        LocalTime now = LocalTime.now();

        la.setText("message :" + r.get(0) + "\n");

        la2.setText("보낸 사람 : " + r.get(1)  + "\n");
        la2.setHorizontalAlignment(SwingConstants.CENTER);

        la3.setText("보낸 날짜 : " + r.get(2)  + "\n");
        la3.setHorizontalAlignment(SwingConstants.CENTER);

        la4.setText("보낸 시간 : " + r.get(3)  + "\n");
        la4.setHorizontalAlignment(SwingConstants.CENTER);

        JButton jb = new JButton("확인");

        jb.addActionListener(new ActionListener() {    //btn1을 눌렀을 때 효과추가
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(300,200);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(la);
        c.add(la2);
        c.add(la3);
        c.add(la4);
        c.add(jb);

        setVisible(true);
    }
}