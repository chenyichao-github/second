package mysql;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCP {
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) throws SQLException {
        var ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/select_test?useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("ab170035");
        ds.setInitialSize(5);
        ds.setMaxActive(20);
        ds.setMinIdle(2);
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from student_table");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
    }
}
