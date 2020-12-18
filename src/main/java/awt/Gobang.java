package awt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gobang {
    private static int BOARD_SIZE = 15;
    private final int TABLE_WIDTH = 535;
    private final int TABLE_HEIGHT = 536;
    private final int RATE = TABLE_WIDTH / BOARD_SIZE;
    private final int X_OFFSET = 5;
    private final int Y_OFFSET = 6;
    BufferedImage table;
    BufferedImage black;
    BufferedImage white;
    BufferedImage selected;
    JFrame f = new JFrame("Îå×ÓÆåÓÎÏ·");
    ChessBoard chessBoard = new ChessBoard();
    private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
    private int selectedX = -1;
    private int selectedY = -1;

    public static void main(String[] args) throws IOException {
        var gb = new Gobang();
        gb.init();
    }

    public void init() throws IOException {
        table = ImageIO.read(new File("image/board.jpg"));
        black = ImageIO.read(new File("image/black.gif"));
        white = ImageIO.read(new File("image/white.gif"));
        selected = ImageIO.read(new File("image/selected.gif"));
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "©ï";
            }
        }
        chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var xPos = (e.getX() - X_OFFSET) / RATE;
                var yPos = (e.getY() - Y_OFFSET) / RATE;
                board[xPos][yPos] = "¡ñ";
                chessBoard.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectedX = -1;
                selectedY = -1;
                chessBoard.repaint();
            }
        });
        chessBoard.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                selectedX = (e.getX() - X_OFFSET) / RATE;
                selectedY = (e.getY() - Y_OFFSET) / RATE;
                chessBoard.repaint();
            }
        });
        f.add(chessBoard);
        f.pack();
        f.setVisible(true);
    }

    class ChessBoard extends JPanel {
        @Override
        public void paint(Graphics g) {
            g.drawImage(table, 0, 0, null);
            if (selectedX >= 0 && selectedY >= 0)
                g.drawImage(selected, selectedX * RATE + X_OFFSET, selectedY * RATE + Y_OFFSET, null);
            for (var i = 0; i < BOARD_SIZE; i++) {
                for (var j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j].equals("¡ñ")) {
                        g.drawImage(black, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                    }
                    if (board[i][j].equals("¡ð")) {
                        g.drawImage(white, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                    }
                }
            }
        }
    }
}
