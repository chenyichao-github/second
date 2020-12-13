package mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TransactionTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var tt = new TransactionTest();
        tt.initParam("src/main/java/mysql/mysql.ini");
        var sqls = new String[]{
                "insert into student_table values(null, 'aaa', 1)",
                "insert into student_table values(null, 'bbb', 1)",
                "insert into student_table values(null, 'ccc', 1)",
                //"insert into student_table values(null, 'ccc', 5)",
        };
        tt.insertInTransaction(sqls);
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void insertInTransaction(String[] sqls) throws ClassNotFoundException {
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            for (var sql : sqls) {
                stmt.executeUpdate(sql);
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
