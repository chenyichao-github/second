package collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        var prop1 = new Properties();
        prop1.setProperty("username", "yeeku");
        prop1.setProperty("password", "123456");
        prop1.store(new FileOutputStream("src/main/java/collection/a.ini"), "comment line");
        var prop2 = new Properties();
        prop2.setProperty("gender", "male");
        prop2.load(new FileInputStream("src/main/java/collection/a.ini"));
        System.out.println(prop2);
    }
}
