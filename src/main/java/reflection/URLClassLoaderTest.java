package reflection;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class URLClassLoaderTest {
    private static Connection conn;

    public static Connection getConn(String url, String user, String pass) throws Exception {
        if (conn == null) {
            URL[] urls = {new URL("file:mysql-connector-java-8.0.13.jar")};
            var myClassLoader = new URLClassLoader(urls);
            var driver = (Driver) myClassLoader.loadClass("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            var props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", pass);
            conn = driver.connect(url, props);
        }
        return conn;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConn("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC", "root", "ab170035"));
    }
}
