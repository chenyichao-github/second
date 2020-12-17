package awt;

import javax.swing.*;
import java.awt.*;

public class BoxSpaceTest {
    private Frame f = new Frame("����");
    private Box horizontal = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();

    public static void main(String[] args) {
        new BoxSpaceTest().init();
    }

    public void init() {
        horizontal.add(new Button("ˮƽ��ťһ"));
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(new Button("ˮƽ��ť��"));
        horizontal.add(Box.createHorizontalStrut(10));
        horizontal.add(new Button("ˮƽ��ť��"));
        vertical.add(new Button("��ֱ��ťһ"));
        vertical.add(Box.createVerticalGlue());
        vertical.add(new Button("��ֱ��ť��"));
        vertical.add(Box.createVerticalStrut(10));
        vertical.add(new Button("��ֱ��ť��"));
        f.add(horizontal, BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }
}

