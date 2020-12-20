package awt;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;

public class DragSourceTest {
    JFrame jf = new JFrame("Swing的拖放支持");
    JLabel srcLabel = new JLabel("Swing的拖放支持.\n" + "将该文本域的内容拖入其他程序.\n");

    public static void main(String[] args) {
        new DragSourceTest().init();
    }

    public void init() {
        DragSource dragSource = DragSource.getDefaultDragSource();
        dragSource.createDefaultDragGestureRecognizer(srcLabel, DnDConstants.ACTION_COPY_OR_MOVE, event -> {
            String txt = srcLabel.getText();
            var transferable = new StringSelection(txt);
            event.startDrag(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), transferable);
        });
        jf.add(new JScrollPane(srcLabel));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

}
