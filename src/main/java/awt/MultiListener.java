package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MultiListener {
    private Frame f = new Frame("����");
    private TextArea ta = new TextArea(6, 40);
    private Button b1 = new Button("��ťһ");
    private Button b2 = new Button("��ť��");

    public static void main(String[] args) {
        new MultiListener().init();
    }

    public void init() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        var f1 = new FirstListener();
        b1.addActionListener(f1);
        b1.addActionListener(new SecondListener());
        b2.addActionListener(f1);
        f.add(ta);
        var p = new Panel();
        p.add(b1);
        p.add(b2);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    class FirstListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ta.append("��һ���¼����������������¼�Դ�ǣ�" + e.getActionCommand() + "\n");
        }
    }

    class SecondListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ta.append("������" + e.getActionCommand() + "��ť\n");
        }
    }
}
