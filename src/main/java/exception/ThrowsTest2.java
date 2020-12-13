package exception;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest2 {
    public static void main(String[] args) throws IOException {
        test();
    }

    public static void test() throws IOException {
        var fis = new FileInputStream("a.txt");
    }
}
