package awt;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest {
    private Frame f = new Frame("����");
    private TextArea ta = new TextArea(6, 40);

    public static void main(String[] args) {
        new WindowListenerTest().init();
    }

    public void init() {
        f.addWindowListener(new MyListener());
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    class MyListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent windowEvent) {
            ta.append("���ڳ��α��򿪣�\n");
        }

        @Override
        public void windowClosing(WindowEvent windowEvent) {
            ta.append("�û��رմ��ڣ�\n");
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent windowEvent) {
            ta.append("���ڱ��ɹ��رգ�\n");
        }

        @Override
        public void windowIconified(WindowEvent windowEvent) {
            ta.append("���ڱ���С����\n");
        }

        @Override
        public void windowDeiconified(WindowEvent windowEvent) {
            ta.append("���ڱ��ָ���\n");
        }

        @Override
        public void windowActivated(WindowEvent windowEvent) {
            ta.append("���ڱ����\n");
        }

        @Override
        public void windowDeactivated(WindowEvent windowEvent) {
            ta.append("����ʧȥ���㣡\n");
        }
    }
}
