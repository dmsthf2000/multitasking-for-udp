package m2hackathon.view;

import m2hackathon.mainMulticast.MainMulticastSocket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

public class SendView extends JFrame{
    JLabel la = new JLabel("You");

    MainMulticastSocket mainSocket = null;
    SendView(MainMulticastSocket mainSocket){
        super("YourFrame");
        System.out.println("sendView");
        this.mainSocket = mainSocket;

        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton backBtn = new JButton("back");
        JButton sendBtn = new JButton("send");
        JTextField tf = new JTextField(10);

        JCheckBox chk1 = new JCheckBox("A",false);
        JCheckBox chk2 = new JCheckBox("B",false);
        JCheckBox chk3 = new JCheckBox("C",false);
        JCheckBox chk4 = new JCheckBox("All",false);

        this.add(chk1);
        this.add(chk2);
        this.add(chk3);
        this.add(chk4);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainView();
            }
        });

        ArrayList<String> sendList = new ArrayList<>();

        chk1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk1.isSelected())
                    sendList.add(chk1.getText());
                else
                    sendList.remove(chk1.getText());

                System.out.println(sendList);
            }
        });

        chk2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk2.isSelected())
                    sendList.add(chk2.getText());
                else
                    sendList.remove(chk2.getText());

                System.out.println(sendList);
            }
        });

        chk3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk3.isSelected())
                    sendList.add(chk3.getText());
                else
                    sendList.remove(chk3.getText());

                System.out.println(sendList);
            }
        });

        chk4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk4.isSelected())
                    sendList.add(chk4.getText());
                else
                    sendList.remove(chk4.getText());

                System.out.println(sendList);
            }
        });

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = tf.getText();
                //setVisible(false);

                mainSocket.sendMessage(sendList, msg);
//                new DialogView(sendList, msg);
//                new RecView(msg);
            }
        });

        c.add(la);
        c.add(backBtn);
        c.add(sendBtn);
        c.add(tf);
        setVisible(true);
    }

}
