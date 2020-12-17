package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventQs {
    private Frame f = new Frame();
    private Button ok = new Button("ȷ��");
    private TextField tf = new TextField(30);

    public static void main(String[] args) {
        new EventQs().init();
    }

    public void init() {
        ok.addActionListener(new OkListener());
        f.add(tf);
        f.add(ok, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    class OkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("�û�������ok��ť");
            tf.setText("Hello World");
        }
    }
}

