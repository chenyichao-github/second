package mysql;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class LoginFrame {
    private final String PROP_FILE = "src/main/java/mysql/mysql.ini";
    private String driver;
    private String url;
    private String user;
    private String pass;
    private JFrame jf = new JFrame("登录");
    private JTextField userField = new JTextField(20);
    private JTextField passField = new JTextField(20);
    private JButton loginButton = new JButton("登录");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new LoginFrame().init();
    }

    public void init() throws IOException, ClassNotFoundException {
        var connProp = new Properties();
        connProp.load(new FileInputStream(PROP_FILE));
        driver = connProp.getProperty("driver");
        url = connProp.getProperty("url");
        user = connProp.getProperty("user");
        pass = connProp.getProperty("pass");
        Class.forName(driver);
        loginButton.addActionListener(e -> {
            if (validate(userField.getText(), passField.getText())) {
                JOptionPane.showMessageDialog(jf, "登录成功");
            } else {
                JOptionPane.showMessageDialog(jf, "登录失败");
            }
        });
        jf.add(userField, BorderLayout.NORTH);
        jf.add(passField);
        jf.add(loginButton, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    private boolean validate(String userName, String userPass) {
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement("select * from jdbc_test where jdbc_name = ? and jdbc_desc = ?");
            pstmt.setString(1, userName);
            pstmt.setString(2, userPass);
            try {
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
