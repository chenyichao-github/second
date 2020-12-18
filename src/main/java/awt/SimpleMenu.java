package awt;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleMenu {
    Menu file = new Menu("�ļ�");
    Menu edit = new Menu("�༭");
    MenuItem newItem = new MenuItem("�½�");
    MenuItem saveItem = new MenuItem("����");
    MenuItem exitItem = new MenuItem("�˳�", new MenuShortcut(KeyEvent.VK_X));
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("�Զ�����");
    MenuItem copyItem = new MenuItem("����");
    MenuItem pasteItem = new MenuItem("ճ��");
    Menu format = new Menu("��ʽ");
    MenuItem commentItem = new MenuItem("ע��", new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelItem = new MenuItem("ȡ��ע��");
    private Frame f = new Frame("����");
    private MenuBar mb = new MenuBar();
    private TextArea ta = new TextArea(6, 40);

    public static void main(String[] args) {
        new SimpleMenu().init();
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
        exitItem.addActionListener(menuListener);
        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);
        edit.add(autoWrap);
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);
        format.add(commentItem);
        format.add(cancelItem);
        edit.add(new MenuItem("-"));
        edit.add(format);
        mb.add(file);
        mb.add(edit);
        f.setMenuBar(mb);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }
}
