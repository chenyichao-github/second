package mysql;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class RowSetFactoryTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        var jt = new RowSetFactoryTest();
        jt.initParam("src/main/java/mysql/mysql.ini");
        jt.update("select * from student_table");
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream("src/main/java/mysql/mysql.ini"));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void update(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        RowSetFactory factory = RowSetProvider.newFactory();
        try {
            JdbcRowSet jdbcRs = factory.createJdbcRowSet();
            jdbcRs.setUrl(url);
            jdbcRs.setUsername(user);
            jdbcRs.setPassword(pass);
            jdbcRs.setCommand(sql);
            jdbcRs.execute();
            jdbcRs.afterLast();
            while (jdbcRs.previous()) {
                System.out.println(jdbcRs.getString(1) + "\t" + jdbcRs.getString(2) + "\t" + jdbcRs.getString(3));
                if (jdbcRs.getInt("student_id") == 3) {
                    jdbcRs.updateString("student_name", "孙悟空");
                    jdbcRs.updateRow();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
