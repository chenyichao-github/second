package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsTest {
    public static void main(String[] args) throws FileNotFoundException {
        var fis = new FileInputStream("a.txt");

    }
}
