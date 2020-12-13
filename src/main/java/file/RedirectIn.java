package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
    public static void main(String[] args) {
        try (var fis = new FileInputStream("src/main/java/file/RedirectIn.java")) {
            System.setIn(fis);
            var sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                System.out.println("键盘输入的内容是：" + sc.next());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
