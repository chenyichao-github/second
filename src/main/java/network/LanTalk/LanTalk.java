package network.LanTalk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.DateFormat;
import java.util.Date;

public class LanTalk extends JFrame {
    private DefaultListModel<UserInfo> listModel = new DefaultListModel<>();
    private JList<UserInfo> friendsList = new JList<>(listModel);
    private DateFormat formatter = DateFormat.getDateTimeInstance();

    public LanTalk() throws HeadlessException {
        super("局域网聊天");
        friendsList.setCellRenderer(new ImageCellRenderer());
        listModel.addElement(new UserInfo("all", "所有人", null, -2000));
        friendsList.addMouseListener(new ChangeMusicListener());
        add(new JScrollPane(friendsList));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(2, 2, 160, 600);
    }

    public static void main(String[] args) {
        var lanTalk = new LanTalk();
        new LoginFrame(lanTalk, "请输入用户名、头像后登录");
    }

    public UserInfo getUserBySocketAddress(SocketAddress address) {
        for (var i = 1; i < getUserNum(); i++) {
            UserInfo user = getUser(i);
            if (user.getAddress() != null && user.getAddress().equals(address)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(UserInfo user) {
        listModel.addElement(user);
    }

    public void removeUser(int pos) {
        listModel.removeElementAt(pos);
    }

    public int getUserNum() {
        return listModel.size();
    }

    public UserInfo getUser(int pos) {
        return listModel.elementAt(pos);
    }

    public void processMsg(DatagramPacket packet, boolean single) {
        var srcAddress = (InetSocketAddress) packet.getSocketAddress();
        if (single) {
            srcAddress = new InetSocketAddress(srcAddress.getHostName(), srcAddress.getPort() - 1);
        }
        UserInfo srcUser = getUserBySocketAddress(srcAddress);
        if (srcUser != null) {
            UserInfo alertUser = single ? srcUser : getUser(0);
            if (alertUser.getChatFrame() == null) {
                alertUser.setChatFrame(new ChatFrame(null, alertUser));
            }
            String tipMsg = single ? "对您说：" : "对大家说：";
            try {
                alertUser.getChatFrame().addString(srcUser.getName() + tipMsg + "......................(" + formatter.format(new Date()) + ")\n" + new String(packet.getData(), 0, packet.getLength(), ComUtil.CHARSET) + "\n");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (!alertUser.getChatFrame().isShowing()) {
                alertUser.getChatFrame().setVisible(true);
            }
        }
    }

    class ChangeMusicListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() >= 2) {
                var user = (UserInfo) friendsList.getSelectedValue();
                if (user.getChatFrame() == null) {
                    user.setChatFrame(new ChatFrame(null, user));
                }
                if (!user.getChatFrame().isShowing()) {
                    user.getChatFrame().setVisible(true);
                }
            }
        }
    }

    class ImageCellRenderer extends JPanel implements ListCellRenderer<UserInfo> {
        private ImageIcon icon;
        private String name;
        private Color background;
        private Color foreground;

        @Override
        public Component getListCellRendererComponent(JList<? extends UserInfo> list, UserInfo userInfo, int index, boolean isSelected, boolean cellHasFocus) {
            icon = new ImageIcon("ico/" + userInfo.getIcon() + ".gif");
            name = userInfo.getName();
            background = isSelected ? list.getSelectionBackground() : list.getBackground();
            foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
            return this;
        }

        @Override
        protected void paintComponent(Graphics g) {
            int imageWidth = icon.getImage().getWidth(null);
            int imageHeight = icon.getImage().getHeight(null);
            g.setColor(background);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(foreground);
            g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);
            g.setFont(new Font("SansSerif", Font.BOLD, 18));
            g.drawString(name, getWidth() / 2 - name.length() * 10, imageHeight + 30);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(60, 80);
        }
    }
}
