package awt;

import java.awt.*;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class BorderLayoutTest2 {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("南"), SOUTH);
        f.add(new Button("北"), NORTH);
        var p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("单击我"));
        f.add(p);
        f.add(new Button("东"), EAST);
        f.pack();
        f.setVisible(true);
    }
}
