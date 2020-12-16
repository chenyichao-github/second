package awt;

import java.awt.*;

public class FlowLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("²âÊÔ´°¿Ú");
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        for (var i = 0; i < 10; i++) {
            f.add(new Button("°´Å¥" + i));
        }
        f.pack();
        f.setVisible(true);
    }
}
