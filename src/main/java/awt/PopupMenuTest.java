package awt;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PopupMenuTest {
    PopupMenu pop = new PopupMenu();
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("�Զ�����");
    MenuItem copyItem = new MenuItem("����");
    MenuItem pasteItem = new MenuItem("ճ��");
    Menu format = new Menu("��ʽ");
    MenuItem commentItem = new MenuItem("ע��", new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelItem = new MenuItem("ȡ��ע��");
    private TextArea ta = new TextArea(4, 30);
    private Frame f = new Frame("����");

    public static void main(String[] args) {
        new PopupMenuTest().init();
    }

    public void init() {
        ActionListener menuListener = e -> {
            var cmd = e.getActionCommand();
            ta.append("����" + cmd + "�˵�" + "\n");
            if (cmd.equals("�˳�")) {
                System.exit(0);
            }
        };
        commentItem.addActionListener(menuListener);
        pop.add(autoWrap);
        pop.addSeparator();
        pop.add(copyItem);
        pop.add(pasteItem);
        format.add(commentItem);
        format.add(cancelItem);
        pop.add(new MenuItem("-"));
        pop.add(format);
        final var p = new Panel();
        p.setPreferredSize(new Dimension(300, 160));
        p.add(pop);
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pop.show(p, e.getX(), e.getY());
                }
            }
        });
        f.add(p);
        f.add(ta, BorderLayout.NORTH);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.pack();
        f.setVisible(true);
    }
}
