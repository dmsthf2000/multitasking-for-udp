package m2.view;

import java.awt.*;

import javax.swing.*;

public class RecView extends JFrame{
    JLabel la = new JLabel();
    RecView(String msg){
        la.setText(msg);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(la);
        setVisible(true);
    }

}