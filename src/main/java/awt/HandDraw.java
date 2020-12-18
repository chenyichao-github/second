package awt;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class HandDraw {
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;
    PopupMenu pop = new PopupMenu();
    MenuItem redItem = new MenuItem("红色");
    MenuItem greenItem = new MenuItem("绿色");
    MenuItem blueItem = new MenuItem("蓝色");
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    private int preX = -1;
    private int preY = -1;
    private Frame f = new Frame("简单手绘程序");
    private DrawCanvas drawArea = new DrawCanvas();
    private Color foreColor = new Color(255, 0, 0);

    public static void main(String[] args) {
        new HandDraw().init();
    }

    public void init() {
        ActionListener menuListener = e -> {
            if (e.getActionCommand().equals("绿色")) {
                foreColor = new Color(0, 255, 0);
            }
            if (e.getActionCommand().equals("红色")) {
                foreColor = new Color(255, 0, 0);
            }
            if (e.getActionCommand().equals("蓝色")) {
                foreColor = new Color(0, 0, 255);
            }
        };
        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);
        pop.add(redItem);
        pop.add(greenItem);
        pop.add(blueItem);
        drawArea.add(pop);
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (preX > 0 && preY > 0) {
                    g.setColor(foreColor);
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                preX = e.getX();
                preY = e.getY();
                drawArea.repaint();
            }
        });
        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pop.show(drawArea, e.getX(), e.getY());
                }
                preX = -1;
                preY = -1;
            }
        });
        f.add(drawArea);
        f.pack();
        f.setVisible(true);
    }

    class DrawCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }
}
