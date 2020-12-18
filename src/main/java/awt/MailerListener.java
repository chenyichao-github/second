package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailerListener implements ActionListener {
    private TextField mailAddress;

    public MailerListener() {
    }

    public MailerListener(TextField mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setMailAddress(TextField mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("程序向" + mailAddress.getText() + "发送邮件...");
    }
}
