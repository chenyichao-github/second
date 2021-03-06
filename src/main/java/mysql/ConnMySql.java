package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnMySql {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test?useSSL=false&serverTimezone=UTC", "root", "ab170035");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select s.*, t.teacher_name from student_table s, teacher_table t where t.teacher_id = s.java_teacher;");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
