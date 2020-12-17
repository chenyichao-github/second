package awt;

import java.awt.*;
import java.awt.event.ActionListener;

public class CardLayoutTest {
    Frame f = new Frame("���Դ���");
    String[] names = {"��һ��", "�ڶ���", "������", "������", "������"};
    Panel p1 = new Panel();

    public static void main(String[] args) {
        new CardLayoutTest().init();
    }

    public void init() {
        final var c = new CardLayout();
        p1.setLayout(c);
        for (var i = 0; i < names.length; i++) {
            p1.add(names[i], new Button(names[i]));
        }
        var p = new Panel();
        ActionListener listener = e -> {
            switch (e.getActionCommand()) {
                case "��һ��":
                    c.previous(p1);
                    break;
                case "��һ��":
                    c.next(p1);
                    break;
                case "��һ��":
                    c.first(p1);
                    break;
                case "���һ��":
                    c.last(p1);
                    break;
                case "������":
                    c.show(p1, "������");
                    break;
            }
        };
        var previous = new Button("��һ��");
        previous.addActionListener(listener);
        var next = new Button("��һ��");
        next.addActionListener(listener);
        var first = new Button("��һ��");
        first.addActionListener(listener);
        var last = new Button("���һ��");
        last.addActionListener(listener);
        var third = new Button("������");
        third.addActionListener(listener);
        p.add(previous);
        p.add(next);
        p.add(first);
        p.add(last);
        p.add(third);
        f.add(p1);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
}
