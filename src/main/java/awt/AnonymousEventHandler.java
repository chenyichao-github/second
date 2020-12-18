package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnonymousEventHandler {
    private Frame f = new Frame("����");
    private TextArea ta = new TextArea(6, 40);

    public static void main(String[] args) {
        new AnonymousEventHandler().init();
    }

    public void init() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("�û���ͼ�رմ��ڣ�\n");
                System.exit(0);
            }
        });
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }
}
