package awt;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

class Dog implements Serializable {
    private String name;
    private int age;

    public Dog() {

    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Dog [ name=" + name + " , age=" + age + " ]";
    }
}

public class CopySerializable {
    Frame f = new Frame("复制对象");
    Button copy = new Button("复制");
    Button paste = new Button("粘贴");
    TextField name = new TextField(15);
    TextField age = new TextField(15);
    TextArea ta = new TextArea(3, 30);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public static void main(String[] args) {
        new CopySerializable().init();
    }

    public void init() {
        var p = new Panel();
        p.add(new Label("姓名"));
        p.add(name);
        p.add(new Label("年龄"));
        p.add(age);
        f.add(p, BorderLayout.NORTH);
        f.add(ta);
        var bp = new Panel();
        copy.addActionListener(e -> copyDog());
        paste.addActionListener(e -> {
            try {
                readDog();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        });
        bp.add(copy);
        bp.add(paste);
        f.add(bp, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public void copyDog() {
        var d = new Dog(name.getText(), Integer.parseInt(age.getText()));
        var ls = new SerialSelection(d);
        clipboard.setContents(ls, null);
    }

    public void readDog() throws ClassNotFoundException, IOException, UnsupportedFlavorException {
        var personFlavor = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + ";class=awt.Dog");
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            var d = (Dog) clipboard.getData(personFlavor);
            ta.setText(d.toString());
        }
    }
}
