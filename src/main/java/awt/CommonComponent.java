package awt;

import javax.swing.*;
import java.awt.*;

public class CommonComponent {
    Frame f = new Frame("����");
    Button ok = new Button("ȷ��");
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("��", cbg, true);
    Checkbox female = new Checkbox("Ů", cbg, false);
    Checkbox married = new Checkbox("�Ƿ��ѻ�?", false);
    Choice colorChooser = new Choice();
    List colorList = new List(6, true);
    TextArea ta = new TextArea(5, 20);
    TextField name = new TextField(50);

    public static void main(String[] args) {
        new CommonComponent().init();
    }

    public void init() {
        colorChooser.add("��ɫ");
        colorChooser.add("��ɫ");
        colorChooser.add("��ɫ");
        colorList.add("��ɫ");
        colorList.add("��ɫ");
        colorList.add("��ɫ");
        var bottom = new Panel();
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom, BorderLayout.SOUTH);
        var checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);
        var topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(checkPanel);
        var top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        f.add(top);
        f.pack();
        f.setVisible(true);
    }
}
