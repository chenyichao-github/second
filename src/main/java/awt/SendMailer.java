package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SendMailer {
    private Frame f = new Frame("≤‚ ‘");
    private TextField tf = new TextField(40);
    private Button send = new Button("∑¢ÀÕ");

    public static void main(String[] args) {
        new SendMailer().init();
    }

    public void init() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        send.addActionListener(new MailerListener(tf));
        f.add(tf);
        f.add(send, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
}
