package mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class QueryExecutor {
    private static Connection conn;
    private static Statement stmt;

    static {
        try {
            var props = new Properties();
            props.load(new FileInputStream("src/main/java/mysql/mysql.ini"));
            String drivers = props.getProperty("driver");
            String url = props.getProperty("url");
            String username = props.getProperty("user");
            String password = props.getProperty("pass");
            Class.forName(drivers);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    JFrame jf = new JFrame("查询执行器");
    private JScrollPane scrollPane;
    private JButton execBn = new JButton("查询");
    private JTextField sqlField = new JTextField(45);

    public static void main(String[] args) {
        new QueryExecutor().init();
    }

    public void init() {
        var top = new JPanel();
        top.add(new JLabel("输入查询语句："));
        top.add(sqlField);
        top.add(execBn);
        execBn.addActionListener(new ExecListener());
        sqlField.addActionListener(new ExecListener());
        jf.add(top, BorderLayout.NORTH);
        jf.setSize(680, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    class ExecListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (scrollPane != null) {
                jf.remove(scrollPane);
            }
            try {
                ResultSet rs = stmt.executeQuery(sqlField.getText());
                ResultSetMetaData rsmd = rs.getMetaData();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<String>> data = new Vector<>();
                for (var i = 0; i < rsmd.getColumnCount(); i++) {
                    columnNames.add(rsmd.getColumnName(i + 1));
                }
                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    for (var i = 0; i < rsmd.getColumnCount(); i++) {
                        v.add(rs.getString(i + 1));
                    }
                    data.add(v);
                }
                var table = new JTable(data, columnNames);
                scrollPane = new JScrollPane(table);
                jf.add(scrollPane);
                jf.validate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
