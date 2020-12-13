package file;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("src/main/java/file/FileInputStreamTest.java");
        var bbuf = new byte[1024];
        var hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            System.out.print(new String(bbuf, 0, hasRead));
        }
        fis.close();
    }
}
