package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowAdapterTest {
    private Frame f = new Frame("����");
    private TextArea ta = new TextArea(6, 40);

    public static void main(String[] args) {
        new WindowAdapterTest().init();
    }

    public void init() {
        f.addWindowListener(new MyListener());
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    class MyListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("�û��رմ��ڣ�\n");
            System.exit(0);
        }
    }
}
