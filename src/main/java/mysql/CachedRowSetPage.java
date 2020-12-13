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

public class CachedRowSetPage {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        var cp = new CachedRowSetPage();
        cp.initParam("src/main/java/mysql/mysql.ini");
        CachedRowSet rs = cp.query("select * from student_table", 3, 2);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
        }
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public CachedRowSet query(String sql, int pageSize, int page) throws ClassNotFoundException {
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRs = factory.createCachedRowSet();
            cachedRs.setPageSize(pageSize);
            cachedRs.populate(rs, (page - 1) * pageSize + 1);
            return cachedRs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
