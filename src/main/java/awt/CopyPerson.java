package awt;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
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
        return "Person[ name=" + name + ", age=" + age + " ]";
    }
}

public class CopyPerson {
    Frame f = new Frame("复制对象");
    Button copy = new Button("复制");
    Button paste = new Button("粘贴");
    TextField name = new TextField(15);
    TextField age = new TextField(15);
    TextArea ta = new TextArea(3, 30);
    Clipboard clipboard = new Clipboard("cp");

    public static void main(String[] args) {
        new CopyPerson().init();
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
        copy.addActionListener(e -> copyPerson());
        paste.addActionListener(e -> {
            try {
                readPerson();
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

    public void copyPerson() {
        var p = new Person(name.getText(), Integer.parseInt(age.getText()));
        var ls = new LocalObjectSelection(p);
        clipboard.setContents(ls, null);
    }

    public void readPerson() throws ClassNotFoundException, IOException, UnsupportedFlavorException {
        var personFlavor = new DataFlavor("application/x-java-jvm-local-objectref;class=awt.Person");
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            var p = (Person) clipboard.getData(personFlavor);
            ta.setText(p.toString());
        }
    }
}
