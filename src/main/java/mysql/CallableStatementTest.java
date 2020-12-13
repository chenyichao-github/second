package mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class CallableStatementTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var ct = new CallableStatementTest();
        ct.initParam("src/main/java/mysql/mysql.ini");
        ct.callProcedure();
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void callProcedure() throws ClassNotFoundException {
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            CallableStatement cstmt = conn.prepareCall("{call add_pro(?, ?, ?)}");
            cstmt.setInt(1, 47);
            cstmt.setInt(2, 58);
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.execute();
            System.out.println("执行结果是：" + cstmt.getInt(3));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
