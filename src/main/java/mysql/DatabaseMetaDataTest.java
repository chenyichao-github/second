package mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseMetaDataTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var dt = new DatabaseMetaDataTest();
        dt.initParam("src/main/java/mysql/mysql.ini");
        dt.info();
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void info() throws ClassNotFoundException {
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTableTypes();
            System.out.println("--MySQL支持的表类型信息--");
            printResultSet(rs);
            rs = dbmd.getTables("select_test", null, "%", new String[]{"TABLE"});
            System.out.println("--当前数据库里的数据表信息--");
            printResultSet(rs);
            rs = dbmd.getPrimaryKeys("select_test", null, "student_table");
            System.out.println("--student_table表的主键信息--");
            printResultSet(rs);
            rs = dbmd.getProcedures("select_test", null, "%");
            System.out.println("--当前数据库里的存储过程信息--");
            printResultSet(rs);
            rs = dbmd.getCrossReference("select_test", null, "teacher_table", null, null, "student_table");
            System.out.println("--teacher_table表和student_table表之间的外键约束--");
            printResultSet(rs);
            rs = dbmd.getColumns("select_test", null, "student_table", "%");
            System.out.println("--student_table表的全部数据列--");
            printResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        for (var i = 0; i < rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i + 1) + "\t");
        }
        System.out.print("\n");
        while (rs.next()) {
            for (var i = 0; i < rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i + 1) + "\t");
            }
            System.out.print("\n");
        }
        rs.close();
    }
}
