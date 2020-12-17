package awt;

import javax.swing.*;
import java.awt.*;

public class CommonComponent {
    Frame f = new Frame("测试");
    Button ok = new Button("确认");
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("男", cbg, true);
    Checkbox female = new Checkbox("女", cbg, false);
    Checkbox married = new Checkbox("是否已婚?", false);
    Choice colorChooser = new Choice();
    List colorList = new List(6, true);
    TextArea ta = new TextArea(5, 20);
    TextField name = new TextField(50);

    public static void main(String[] args) {
        new CommonComponent().init();
    }

    public void init() {
        colorChooser.add("红色");
        colorChooser.add("绿色");
        colorChooser.add("蓝色");
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");
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
