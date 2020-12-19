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
    MenuItem redItem = new MenuItem("��ɫ");
    MenuItem greenItem = new MenuItem("��ɫ");
    MenuItem blueItem = new MenuItem("��ɫ");
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private int preX = -1;
    private int preY = -1;
    private Frame f = new Frame("���Դ���");
    private DrawCanvas drawArea = new DrawCanvas();
    private Color foreColor = new Color(255, 0, 0);

    public static void main(String[] args) {
        new CopyImage().init();
    }

    public void init() {
        ActionListener menuListener = e -> {
            if (e.getActionCommand().equals("��ɫ")) {
                foreColor = new Color(0, 255, 0);
            }
            if (e.getActionCommand().equals("��ɫ")) {
                foreColor = new Color(255, 0, 0);
            }
            if (e.getActionCommand().equals("��ɫ")) {
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
            // ʵ�ְ����������϶����¼�������
            public void mouseDragged(MouseEvent e) {
                // ���preX��preY����0
                if (preX > 0 && preY > 0) {
                    // ���õ�ǰ��ɫ
                    g.setColor(foreColor);
                    // ���ƴ���һ������϶��¼��㵽��������϶��¼�����߶�
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                // ����ǰ����¼����X��Y���걣������
                preX = e.getX();
                preY = e.getY();
                // �ػ�drawArea����
                drawArea.repaint();
            }
        });
        drawArea.addMouseListener(new MouseAdapter() {
            // ʵ������ɿ����¼�������
            public void mouseReleased(MouseEvent e) {
                // �����Ҽ��˵�
                if (e.isPopupTrigger()) {
                    pop.show(drawArea, e.getX(), e.getY());
                }
                // �ɿ�����ʱ������һ������϶��¼���X��Y������Ϊ-1��
                preX = -1;
                preY = -1;
            }
        });
        f.add(drawArea);
        var p = new Panel();
        var copy = new Button("����");
        var paste = new Button("ճ��");
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
