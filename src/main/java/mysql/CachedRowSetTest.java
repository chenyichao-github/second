package mysql;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CachedRowSetTest {
    private static String driver;
    private static String url;
    private static String user;
    private static String pass;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        var ct = new CachedRowSetTest();
        ct.initParam("src/main/java/mysql/mysql.ini");
        CachedRowSet rs = ct.query("select * from student_table");
        rs.afterLast();
        while (rs.previous()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            if (rs.getInt("student_id") == 3) {
                rs.updateString("student_name", "猪八戒");
                rs.updateRow();
            }
        }
        Connection conn = DriverManager.getConnection(url, user, pass);
        conn.setAutoCommit(false);
        rs.acceptChanges(conn);
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public CachedRowSet query(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet cachedRs = factory.createCachedRowSet();
        cachedRs.populate(rs);
        rs.close();
        stmt.close();
        conn.close();
        return cachedRs;
    }
}
