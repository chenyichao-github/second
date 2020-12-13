package base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
    public static void main(String[] args) throws IOException {
        Map<String, String> env = System.getenv();
        for (var name : env.keySet()) {
            System.out.println(name + " ---> " + env.get(name));
        }
        System.out.println(System.getenv("HOME"));
        Properties props = System.getProperties();
        props.store(new FileOutputStream("src/main/java/base/props.txt"), "System Properties");
        System.out.println(System.getProperty("os.name"));
    }
}
