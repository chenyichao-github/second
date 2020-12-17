package awt;

import java.awt.*;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class BorderLayoutTest2 {
    public static void main(String[] args) {
        var f = new Frame("���Դ���");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("��"), SOUTH);
        f.add(new Button("��"), NORTH);
        var p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("������"));
        f.add(p);
        f.add(new Button("��"), EAST);
        f.pack();
        f.setVisible(true);
    }
}
