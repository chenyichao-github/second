package awt;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class SimpleClipboard {
    private Frame f = new Frame("¼òµ¥µÄ¼ôÌù°å³ÌÐò");
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private TextArea jtaCopyTo = new TextArea(5, 20);
    private TextArea jtaPaste = new TextArea(5, 20);
    private Button btCopy = new Button("¸´ÖÆ");
    private Button btPaste = new Button("Õ³Ìù");

    public static void main(String[] args) {
        new SimpleClipboard().init();
    }

    public void init() {
        var p = new Panel();
        p.add(btCopy);
        p.add(btPaste);
        btCopy.addActionListener(event -> {
            var contents = new StringSelection(jtaCopyTo.getText());
            clipboard.setContents(contents, null);
        });
        btPaste.addActionListener(event -> {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    var content = (String) clipboard.getData(DataFlavor.stringFlavor);
                    jtaPaste.append(content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        var box = new Box(BoxLayout.X_AXIS);
        box.add(jtaCopyTo);
        box.add(jtaPaste);
        f.add(p, BorderLayout.SOUTH);
        f.add(box, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}
