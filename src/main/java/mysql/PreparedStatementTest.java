package mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var pt = new PreparedStatementTest();
        pt.initParam("src/main/java/mysql/mysql.ini");
        pt.insertUseStatement();
        pt.insertUsePrepare();
    }

    public void initParam(String paramFile) throws IOException, ClassNotFoundException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        Class.forName(driver);
    }

    public void insertUseStatement() {
        long start = System.currentTimeMillis();
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            for (var i = 0; i < 100; i++) {
                stmt.executeUpdate("insert into student_table values(null, '姓名" + i + "', 1)");
            }
            System.out.println("使用Statement费时:" + (System.currentTimeMillis() - start));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertUsePrepare() {
        long start = System.currentTimeMillis();
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement("insert into student_table values (null, ?, 1)");
            for (var i = 0; i < 100; i++) {
                pstmt.setString(1, "姓名" + i);
                pstmt.executeUpdate();
            }
            System.out.println("使用PrepareStatement费时:" + (System.currentTimeMillis() - start));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
