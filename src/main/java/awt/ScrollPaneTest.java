package awt;

import java.awt.*;

public class ScrollPaneTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        var sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        sp.add(new TextField(20));
        sp.add(new Button("单击我"));
        f.add(sp);
        f.setBounds(30, 30, 300, 120);
        f.setVisible(true);
    }
}
