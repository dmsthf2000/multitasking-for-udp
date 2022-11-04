package m2hackathon.view;

import m2hackathon.mainMulticast.MainMulticastSocket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class SendView extends JFrame{

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
        JButton LogBtn = new JButton("Log");
        JTextArea tf = new JTextArea(20,40);

        JCheckBox chk1 = new JCheckBox("Application",false);
        JCheckBox chk2 = new JCheckBox("Server",false);
        JCheckBox chk3 = new JCheckBox("Solution",false);
        JCheckBox chk4 = new JCheckBox("Engine",false);
        JCheckBox chk5 = new JCheckBox("PM",false);
        JCheckBox chk6 = new JCheckBox("QA",false);
        JCheckBox chk7 = new JCheckBox("All",false);

        this.add(chk1);
        this.add(chk2);
        this.add(chk3);
        this.add(chk4);
        this.add(chk5);
        this.add(chk6);
        this.add(chk7);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainSocket.leaveGroup();
                new MainView();
            }
        });

        LogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainSocket.getAllData();
            }
        });

        ArrayList<String> sendList = new ArrayList<>();

        chk1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk1.isSelected())
                    sendList.add("A");
                else
                    sendList.remove("A");

                System.out.println(sendList);
            }
        });

        chk2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk2.isSelected())
                    sendList.add("B");
                else
                    sendList.remove("B");

                System.out.println(sendList);
            }
        });

        chk3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk3.isSelected())
                    sendList.add("C");
                else
                    sendList.remove("C");

                System.out.println(sendList);
            }
        });

        chk4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk4.isSelected())
                    sendList.add("D");
                else
                    sendList.remove("D");

                System.out.println(sendList);
            }
        });

        chk5.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk5.isSelected())
                    sendList.add("E");
                else
                    sendList.remove("E");

                System.out.println(sendList);
            }
        });

        chk6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(chk6.isSelected())
                    sendList.add("F");
                else
                    sendList.remove("F");

                System.out.println(sendList);
            }
        });

        chk7.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                ArrayList<String> arr = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
                if(chk7.isSelected()) {
                    sendList.addAll(arr);
                }
                else {
                    sendList.removeAll(arr);

                }

                System.out.println(sendList);
            }
        });


        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = tf.getText();
                mainSocket.sendMessage(sendList, msg);
            }
        });

        c.add(tf);
        c.add(sendBtn);
        c.add(backBtn);
        c.add(LogBtn);
        setVisible(true);
    }

}