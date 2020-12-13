package awt;

import java.awt.*;

public class PanelTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        var p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("单击我"));
        f.add(p);
        f.setBounds(30, 30, 300, 120);
        f.setVisible(true);
    }
}
