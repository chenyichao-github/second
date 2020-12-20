package awt;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

public class JToolBarTest {
    JFrame jf = new JFrame("≤‚ ‘π§æﬂÃı");
    JTextArea jta = new JTextArea(6, 35);
    JToolBar jtb = new JToolBar();
    JMenuBar jmb = new JMenuBar();
    JMenu edit = new JMenu("±‡º≠");
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Action pasteAction = new AbstractAction("’≥Ã˘", new ImageIcon("ico/paste.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    var content = (String) clipboard.getData(DataFlavor.stringFlavor);
                    jta.replaceRange(content, jta.getSelectionStart(), jta.getSelectionEnd());
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    };
    Action copyAction = new AbstractAction("∏¥÷∆", new ImageIcon("ico/copy.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            var contents = new StringSelection(jta.getSelectedText());
            clipboard.setContents(contents, null);
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                pasteAction.setEnabled(true);
            }
        }
    };

    public static void main(String[] args) {
        new JToolBarTest().init();
    }

    public void init() {
        pasteAction.setEnabled(false);
        jf.add(new JScrollPane(jta));
        var copyBn = new JButton(copyAction);
        var pasteBn = new JButton(pasteAction);
        var jp = new JPanel();
        jp.add(copyBn);
        jp.add(pasteBn);
        jf.add(jp, BorderLayout.SOUTH);
        jtb.add(copyAction);
        jtb.addSeparator();
        jtb.add(pasteAction);
        edit.add(copyAction);
        edit.add(pasteAction);
        jmb.add(edit);
        jf.setJMenuBar(jmb);
        jtb.setMargin(new Insets(20, 10, 5, 30));
        jf.add(jtb, BorderLayout.NORTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}
