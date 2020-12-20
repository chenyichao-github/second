package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class HandDraw {
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;
    JPopupMenu pop = new JPopupMenu();
    JMenuItem chooseColor = new JMenuItem("选择颜色");
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    private int preX = -1;
    private int preY = -1;
    private JFrame f = new JFrame("简单手绘程序");
    private DrawCanvas drawArea = new DrawCanvas();
    private Color foreColor = new Color(255, 0, 0);

    public static void main(String[] args) {
        new HandDraw().init();
    }

    public void init() {
        chooseColor.addActionListener(ae -> {
            final var colorPane = new JColorChooser(foreColor);
            var jd = JColorChooser.createDialog(f, "选择画笔颜色", false, colorPane, e -> foreColor = colorPane.getColor(), null);
            jd.setVisible(true);
        });
        pop.add(chooseColor);
        drawArea.setComponentPopupMenu(pop);
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
                preX = -1;
                preY = -1;
            }
        });
        f.add(drawArea);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    class DrawCanvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }
}
