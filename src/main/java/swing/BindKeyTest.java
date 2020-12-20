package awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

public class BindKeyTest {
    JFrame jf = new JFrame("≤‚ ‘º¸≈Ã∞Û∂®");
    JTextArea jta = new JTextArea(5, 30);
    JButton jb = new JButton("∑¢ÀÕ");
    JTextField jtf = new JTextField(15);

    public static void main(String[] args) {
        new BindKeyTest().init();
    }

    public void init() {
        jf.add(jta);
        var jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);
        jf.add(jp, BorderLayout.SOUTH);
        Action sendMsg = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
            }
        };
        jb.addActionListener(sendMsg);
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n', InputEvent.CTRL_DOWN_MASK), "send");
        jtf.getActionMap().put("send", sendMsg);
        jf.pack();
        jf.setVisible(true);
    }
}
