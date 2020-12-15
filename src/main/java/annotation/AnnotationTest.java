package annotation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnotationTest {
    private JFrame mainWin = new JFrame("ʹ��ע����¼�������");
    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("ȷ��");
    @ActionListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("ȡ��");

    public static void main(String[] args) {
        new AnnotationTest().init();
    }

    public void init() {
        var jp = new JPanel();
        jp.add(ok);
        jp.add(cancel);
        mainWin.add(jp);
        ActionListenerInstaller.processAnnotations(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }
}

class OkListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "������ȷ�ϰ�ť");
    }
}

class CancelListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "������ȡ����ť");
    }
}
