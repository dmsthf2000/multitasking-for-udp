package m2hackathon.view;

import java.util.ArrayList;

public class DialogView
{
    ArrayList<String> sendList = new ArrayList();
    String msg = "";
    public DialogView(ArrayList<String> sendList, String msg)
    {
        this.sendList = sendList;
        this.msg = msg;
        System.out.println(sendList + msg);
    }
//    // 필요한 필드 선언
//    JFrame jFrame = new JFrame("J다이얼로그 예제");
//    JDialog jDialog = new JDialog(jFrame, "JDialog 타이틀");
//    JButton jButton = new JButton("Click");
//
//    // GUI 구현 생성자
//    public DialogView()
//    {
//        // 다이얼로그에 버튼 추가
//        jDialog.add(jButton, "South");
//
//        // 기본 프레임 크기와 보기 설정
//        jFrame.setSize(200, 200);
//        jFrame.setVisible(true);
//        //X버튼 누르면 프로그램 종료
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // 다이얼로그의 크기와 보기 설정
//        jDialog.setSize(100, 100);
//        jDialog.setVisible(true);
//        //★X버튼 누르면 다이얼로그만 종료
//        jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//    }
}