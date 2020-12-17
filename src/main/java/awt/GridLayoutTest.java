package awt;

import java.awt.*;

public class GridLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("¼ÆËãÆ÷");
        var p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1, BorderLayout.NORTH);
        var p2 = new Panel();
        p2.setLayout(new GridLayout(3, 5, 4, 4));
        String[] names = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "."};
        for (var i = 0; i < names.length; i++) {
            p2.add(new Button(names[i]));
        }
        f.add(p2);
        f.pack();
        f.setVisible(true);
    }
}
