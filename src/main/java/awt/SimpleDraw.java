package awt;

import java.awt.*;
import java.util.Random;

public class SimpleDraw {
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";
    private Frame f = new Frame("�򵥻�ͼ");
    private Button rect = new Button("���ƾ���");
    private Button oval = new Button("����Բ��");
    private MyCanvas drawArea = new MyCanvas();
    private String shape = "";

    public static void main(String[] args) {
        new SimpleDraw().init();
    }

    public void init() {
        var p = new Panel();
        rect.addActionListener(e -> {
            shape = RECT_SHAPE;
            drawArea.repaint();
        });
        oval.addActionListener(e -> {
            shape = OVAL_SHAPE;
            drawArea.repaint();
        });
        p.add(rect);
        p.add(oval);
        drawArea.setPreferredSize(new Dimension(250, 180));
        f.add(drawArea);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            var rand = new Random();
            if (shape.equals(RECT_SHAPE)) {
                g.setColor(new Color(220, 100, 80));
                g.fillRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
            }
            if (shape.equals(OVAL_SHAPE)) {
                g.setColor(new Color(80, 100, 200));
                g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
            }
        }
    }
}
