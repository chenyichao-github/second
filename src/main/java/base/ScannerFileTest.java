package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        var sc = new Scanner(new File("src/main/java/6base/ScannerFileTest.java"));
        System.out.println("ScannerFileTest.java文件内容如下：");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
