package m2hackathon.view;
import m2hackathon.mainMulticast.MainMulticastSocket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainView extends JFrame {
    JPanel jp = new JPanel(); // 패널 초기화
    JButton jb = new JButton("Application"); // 버튼 초기화
    JButton jb2 = new JButton("Server"); // 버튼 초기화
    JButton jb3 = new JButton("Solution"); // 버튼 초기화
    JButton jb4 = new JButton("Engine"); // 버튼 초기화
    JButton jb5 = new JButton("PM"); // 버튼 초기화
    JButton jb6 = new JButton("QA"); // 버튼 초기화

    //connect MainMultiSocket
    MainMulticastSocket mainSocket = new MainMulticastSocket();

    public MainView() {
        super("Test"); // JFrame의 생성자에 값을 입력하면 윈도창에 해당 값이 입력됩니다.

        jp.add(jb); // jp라는 패널에 jb라는 버튼 추가
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        add(jp); // JFrame에 jp라는 패널 추가

        jb.addActionListener(new ActionListener() {    //btn1을 눌렀을 때 효과추가
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SendView(mainSocket);
                mainSocket.init("A");

            }
        });

        jb2.addActionListener(new ActionListener() {    //btn1을 눌렀을 때 효과추가
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SendView(mainSocket);
                mainSocket.init("B");
            }
        });

        jb3.addActionListener(new ActionListener() {    //btn1을 눌렀을 때 효과추가
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SendView(mainSocket);
                mainSocket.init("C");
            }
        });

        jb4.addActionListener(new ActionListener() {    //btn1을 눌렀을 때 효과추가
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SendView(mainSocket);
                mainSocket.init("D");
            }
        });

        jb5.addActionListener(new ActionListener() {    //btn1을 눌렀을 때 효과추가
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SendView(mainSocket);
                mainSocket.init("E");
            }
        });

        jb6.addActionListener(new ActionListener() {    //btn1을 눌렀을 때 효과추가
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SendView(mainSocket);
                mainSocket.init("F");
            }
        });


        setSize(600, 600); // 윈도우의 크기 가로x세로
        setVisible(true); // 창을 보여줄떄 true, 숨길때 false
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼을 눌렀을때 종료
    }
}