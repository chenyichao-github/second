package awt;

import javax.swing.*;
import java.awt.*;

public class BoxTest {
    private Frame f = new Frame("测试窗口");
    private Box horizontal = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();

    public static void main(String[] args) {
        new BoxTest().init();
    }

    public void init() {
        horizontal.add(new Button("水平按钮一"));
        horizontal.add(new Button("水平按钮二"));
        vertical.add(new Button("垂直按钮一"));
        vertical.add(new Button("垂直按钮二"));
        f.add(horizontal, BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }
}
