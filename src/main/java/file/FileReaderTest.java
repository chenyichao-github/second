package file;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        try {
            var fr = new FileReader("src/main/java/file/FileReaderTest.java");
            var cbuf = new char[32];
            var hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
