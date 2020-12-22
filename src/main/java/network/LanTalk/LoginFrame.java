package network.LanTalk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JDialog {
    public static ComUtil comUtil;
    public JLabel tip;
    public JTextField userField = new JTextField("李刚", 20);
    public JComboBox<Integer> iconList = new JComboBox<>(
            new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    );
    private JButton loginBn = new JButton("登录");
    private LanTalk chatFrame;

    public LoginFrame(LanTalk parent, String msg) {
        super(parent, "输入名字后登录", true);
        this.chatFrame = parent;
        setLayout(new GridLayout(5, 1));
        var jp = new JPanel();
        tip = new JLabel(msg);
        tip.setFont(new Font("Serif", Font.BOLD, 16));
        jp.add(tip);
        add(jp);
        add(getPanel("用户名", userField));
        iconList.setPreferredSize(new Dimension(224, 20));
        add(getPanel("图    标", iconList));
        var bp = new JPanel();
        loginBn.addActionListener(new MyActionListener(this));
        bp.add(loginBn);
        add(bp);
        pack();
        setVisible(true);
    }

    private JPanel getPanel(String name, JComponent jf) {
        var jp = new JPanel();
        jp.add(new JLabel(name + "："));
        jp.add(jf);
        return jp;
    }

    public void setTipMsg(String tip) {
        this.tip.setText(tip);
    }

    class MyActionListener implements ActionListener {
        private LoginFrame loginFrame;

        public MyActionListener(LoginFrame loginFrame) {
            this.loginFrame = loginFrame;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                comUtil = new ComUtil(chatFrame);
                final String loginMsg = YeekuProtocol.PRESENCE + userField.getText() + YeekuProtocol.SPLITTER + iconList.getSelectedObjects()[0] + YeekuProtocol.PRESENCE;
                comUtil.broadCast(loginMsg);
                Timer timer = new Timer(1000 * 10, event -> comUtil.broadCast(loginMsg));
                timer.start();
                loginFrame.setVisible(false);
                chatFrame.setVisible(true);
            } catch (Exception ex) {
                loginFrame.setTipMsg("确认30001端口空闲，且网络正常！");
            }
        }
    }
}
