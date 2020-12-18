package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleEventHandler extends WindowAdapter {
    private Frame f = new Frame();
    private TextArea ta = new TextArea(6, 40);

    public static void main(String[] args) {
        new SimpleEventHandler().init();
    }

    public void init() {
        f.addWindowListener(this);
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("用户关闭窗口！\n");
        System.exit(0);
    }
}
