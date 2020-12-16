package awt;

import java.awt.*;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;

public class BorderLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("���Դ���");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("��"), SOUTH);
        f.add(new Button("��"), NORTH);
        f.add(new Button("��"));
        f.add(new Button("��"), EAST);
        f.add(new Button("��"), WEST);
        f.pack();
        f.setVisible(true);
    }
}
