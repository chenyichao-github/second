package network.LanTalk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.net.InetSocketAddress;

public class ChatFrame extends JDialog {
    JTextArea msgArea = new JTextArea(12, 45);
    JTextField chatField = new JTextField(30);
    JButton sendBn = new JButton("发送");
    UserInfo user;

    public ChatFrame(LanTalk parent, final UserInfo user) {
        super(parent, "和" + user.getName() + "聊天中", false);
        this.user = user;
        msgArea.setEditable(false);
        add(new JScrollPane(msgArea));
        var bottom = new JPanel();
        bottom.add(new JLabel("输入信息："));
        bottom.add(chatField);
        bottom.add(sendBn);
        add(bottom, BorderLayout.SOUTH);
        var sendAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                var dest = (InetSocketAddress) user.getAddress();
                if (dest == null) {
                    LoginFrame.comUtil.broadCast(chatField.getText());
                    msgArea.setText("您对大家说：" + chatField.getText() + "\n" + msgArea.getText());
                } else {
                    dest = new InetSocketAddress(dest.getHostName(), dest.getPort() + 1);
                    LoginFrame.comUtil.sendSingle(chatField.getText(), dest);
                    msgArea.setText("您对" + user.getName() + "说：" + chatField.getText() + "\n" + msgArea.getText());
                }
                chatField.setText("");
            }
        };
        sendBn.addActionListener(sendAction);
        chatField.getInputMap().put(KeyStroke.getKeyStroke('\n', InputEvent.CTRL_DOWN_MASK), "send");
        chatField.getActionMap().put("send", sendAction);
        pack();
    }

    public void addString(String msg) {
        msgArea.setText(msg + "\n" + msgArea.getText());
    }
}
