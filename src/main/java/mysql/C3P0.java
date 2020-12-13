package mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0 {
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) throws PropertyVetoException, SQLException {
        var ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/select_test?useSSL=false&serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("ab170035");
        ds.setMaxPoolSize(40);
        ds.setMinPoolSize(2);
        ds.setInitialPoolSize(10);
        ds.setMaxStatements(180);
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from student_table;");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
    }
}
