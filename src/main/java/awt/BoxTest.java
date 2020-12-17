package awt;

import javax.swing.*;
import java.awt.*;

public class BoxTest {
    private Frame f = new Frame("���Դ���");
    private Box horizontal = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();

    public static void main(String[] args) {
        new BoxTest().init();
    }

    public void init() {
        horizontal.add(new Button("ˮƽ��ťһ"));
        horizontal.add(new Button("ˮƽ��ť��"));
        vertical.add(new Button("��ֱ��ťһ"));
        vertical.add(new Button("��ֱ��ť��"));
        f.add(horizontal, BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }
}
