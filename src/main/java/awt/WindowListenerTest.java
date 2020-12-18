package awt;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest {
    private Frame f = new Frame("测试");
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
            ta.append("窗口初次被打开！\n");
        }

        @Override
        public void windowClosing(WindowEvent windowEvent) {
            ta.append("用户关闭窗口！\n");
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent windowEvent) {
            ta.append("窗口被成功关闭！\n");
        }

        @Override
        public void windowIconified(WindowEvent windowEvent) {
            ta.append("窗口被最小化！\n");
        }

        @Override
        public void windowDeiconified(WindowEvent windowEvent) {
            ta.append("窗口被恢复！\n");
        }

        @Override
        public void windowActivated(WindowEvent windowEvent) {
            ta.append("窗口被激活！\n");
        }

        @Override
        public void windowDeactivated(WindowEvent windowEvent) {
            ta.append("窗口失去焦点！\n");
        }
    }
}
