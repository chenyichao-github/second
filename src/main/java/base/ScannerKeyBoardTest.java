package base;

import java.util.Scanner;

public class ScannerKeyBoardTest {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            System.out.println("键盘输入的内容是：" + sc.next());
            if (sc.hasNext("-1")) {
                System.out.println("输入结束");
                System.exit(0);
            }
        }
    }
}
