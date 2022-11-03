package m2hackathon.view;

import m2hackathon.mainMulticast.MainMulticastSocket;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

public class RecView extends JFrame{
    JLabel la = new JLabel();
    public RecView(ArrayList<String> receiveArray)
    {
        super("recView");
        ArrayList<String> r = new ArrayList<>();
        r = receiveArray;
        la.setText(r.toString());
        setSize(600,600);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(la);
        setVisible(true);
    }
}