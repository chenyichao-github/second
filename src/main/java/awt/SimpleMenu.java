package awt;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleMenu {
    Menu file = new Menu("文件");
    Menu edit = new Menu("编辑");
    MenuItem newItem = new MenuItem("新建");
    MenuItem saveItem = new MenuItem("保存");
    MenuItem exitItem = new MenuItem("退出", new MenuShortcut(KeyEvent.VK_X));
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
    MenuItem copyItem = new MenuItem("复制");
    MenuItem pasteItem = new MenuItem("粘贴");
    Menu format = new Menu("格式");
    MenuItem commentItem = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelItem = new MenuItem("取消注释");
    private Frame f = new Frame("测试");
    private MenuBar mb = new MenuBar();
    private TextArea ta = new TextArea(6, 40);

    public static void main(String[] args) {
        new SimpleMenu().init();
    }

    public void init() {
        ActionListener menuListener = e -> {
            var cmd = e.getActionCommand();
            ta.append("单击" + cmd + "菜单" + "\n");
            if (cmd.equals("退出")) {
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
