package awt;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CopyImage {
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;
    List<Image> imageList = new ArrayList<>();
    PopupMenu pop = new PopupMenu();
    MenuItem redItem = new MenuItem("红色");
    MenuItem greenItem = new MenuItem("绿色");
    MenuItem blueItem = new MenuItem("蓝色");
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private int preX = -1;
    private int preY = -1;
    private Frame f = new Frame("测试窗口");
    private DrawCanvas drawArea = new DrawCanvas();
    private Color foreColor = new Color(255, 0, 0);

    public static void main(String[] args) {
        new CopyImage().init();
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
            // 实现按下鼠标键并拖动的事件处理器
            public void mouseDragged(MouseEvent e) {
                // 如果preX和preY大于0
                if (preX > 0 && preY > 0) {
                    // 设置当前颜色
                    g.setColor(foreColor);
                    // 绘制从上一次鼠标拖动事件点到本次鼠标拖动事件点的线段
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                // 将当前鼠标事件点的X、Y坐标保存起来
                preX = e.getX();
                preY = e.getY();
                // 重绘drawArea对象
                drawArea.repaint();
            }
        });
        drawArea.addMouseListener(new MouseAdapter() {
            // 实现鼠标松开的事件处理器
            public void mouseReleased(MouseEvent e) {
                // 弹出右键菜单
                if (e.isPopupTrigger()) {
                    pop.show(drawArea, e.getX(), e.getY());
                }
                // 松开鼠标键时，把上一次鼠标拖动事件的X、Y坐标设为-1。
                preX = -1;
                preY = -1;
            }
        });
        f.add(drawArea);
        var p = new Panel();
        var copy = new Button("复制");
        var paste = new Button("粘贴");
        copy.addActionListener(event -> {
            var contents = new ImageSelection(image);
            clipboard.setContents(contents, null);
        });
        paste.addActionListener(event -> {
            if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor)) {
                try {
                    imageList.add((Image) clipboard.getData(DataFlavor.imageFlavor));
                    drawArea.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        p.add(copy);
        p.add(paste);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    class DrawCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
            for (var img : imageList) {
                g.drawImage(img, 0, 0, null);
            }
        }
    }
}
