package mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var ed = new ExecuteDDL();
        ed.initParam("src/main/java/mysql/mysql.ini");
        ed.createTable("create table jdbc_test (jdbc_id int auto_increment primary key, jdbc_name varchar(255), jdbc_desc text);");
        System.out.println("-----建表成功-----");
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void createTable(String sql) throws ClassNotFoundException {
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
