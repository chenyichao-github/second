package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try {
            var fis = new FileInputStream("src/main/java/file/FileOutputStreamTest.java");
            File newFile = new File("src/main/java/file/newFile.txt");
            newFile.createNewFile();
            var fos = new FileOutputStream("src/main/java/file/newFile.txt");
            var bbuf = new byte[1024];
            var hasRead = 0;
            while ((hasRead = fis.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
