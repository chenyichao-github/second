package swing;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BorderTest {
    private JFrame jf = new JFrame("≤‚ ‘±ﬂøÚ");

    public static void main(String[] args) {
        new BorderTest().init();
    }

    public void init() {
        jf.setLayout(new GridLayout(2, 4));
        Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
        jf.add(getPanelWithBorder(bb, "BevelBorder"));
        Border lb = BorderFactory.createLineBorder(Color.ORANGE, 10);
        jf.add(getPanelWithBorder(lb, "LineBorder"));
        Border eb = BorderFactory.createEmptyBorder(20, 5, 10, 30);
        jf.add(getPanelWithBorder(eb, "EmptyBorder"));
        Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
        jf.add(getPanelWithBorder(etb, "EtchedBorder"));
        var tb = new TitledBorder(lb, "≤‚ ‘±ÍÃ‚", TitledBorder.LEFT, TitledBorder.BOTTOM, new Font("StSong", Font.BOLD, 18), Color.BLUE);
        jf.add(getPanelWithBorder(tb, "TitledBorder"));
        var mb = new MatteBorder(20, 5, 10, 30, Color.GREEN);
        jf.add(getPanelWithBorder(mb, "MatteBorder"));
        var cb = new CompoundBorder(new LineBorder(Color.RED, 8), tb);
        jf.add(getPanelWithBorder(cb, "CompoundBorder"));
        jf.pack();
        jf.setVisible(true);
    }

    public JPanel getPanelWithBorder(Border b, String BorderName) {
        var p = new JPanel();
        p.add(new JLabel(BorderName));
        p.setBorder(b);
        return p;
    }
}
