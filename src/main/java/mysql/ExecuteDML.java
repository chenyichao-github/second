package mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var ed = new ExecuteDML();
        ed.initParam("src/main/java/mysql/mysql.ini");
        int result = ed.insertData("insert into jdbc_test(jdbc_name, jdbc_desc) select s.student_name, t.teacher_name from student_table s, teacher_table t where s.java_teacher = t.teacher_id;");
        System.out.println("--系统中共有" + result + "条记录受影响--");
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public int insertData(String sql) throws ClassNotFoundException {
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
