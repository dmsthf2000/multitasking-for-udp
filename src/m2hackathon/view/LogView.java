package m2hackathon.view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.List;

public class LogView extends JFrame{
    public LogView(List<List<String>> logDataArray) {
        String column[] = {"메시지", "송신자","받은 날짜", "받은 시간"};

        String[][] ints = convertToArray(logDataArray);

        DefaultTableModel model = new DefaultTableModel(ints, column);

        //2. Model을 매개변수로 설정, new JTable(b,a)도 가능하지만
        //삽입 삭제를 하기 위해 해당 방법을 사용합니다
        JTable table = new JTable(model); //

        //3. 결과적으로는 JScrollPane를 추가합니다.
        JScrollPane sc = new JScrollPane(table);

        //4. 컴포넌트에  Table 추가
        add(sc);

        setBounds(0, 0, 300, 150);
        setVisible(true);

    }

    public static String[][] convertToArray(List<List<String>> list) {
        String[][] result = new String[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            result[i] = new String[list.get(i).size()];
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                result[i][j] = String.valueOf(list.get(i).get(j));
            }
        }

        return result;
    }

    }

