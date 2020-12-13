package mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteSQL {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var es = new ExecuteSQL();
        es.initParam("src/main/java/mysql/mysql.ini");
        System.out.println("------执行删除表的DDL语句-----");
        es.executeSql("drop table if exists my_test");
        System.out.println("------执行建表的DDL语句-----");
        es.executeSql("create table my_test (test_id int auto_increment primary key, test_name varchar(255))");
        System.out.println("------执行插入数据的DML语句-----");
        es.executeSql("insert into my_test(test_name) select student_name from student_table");
        System.out.println("------执行查询数据的查询语句-----");
        es.executeSql("select * from my_test");
    }

    public void initParam(String paramFile) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void executeSql(String sql) throws ClassNotFoundException {
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            boolean hasResultSet = stmt.execute(sql);
            if (hasResultSet) {
                try {
                    ResultSet rs = stmt.getResultSet();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    while (rs.next()) {
                        for (var i = 0; i < columnCount; i++) {
                            System.out.print(rs.getString(i + 1) + "\t");
                        }
                        System.out.print("\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("该SQL语句影响的记录有" + stmt.getUpdateCount() + "条");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
