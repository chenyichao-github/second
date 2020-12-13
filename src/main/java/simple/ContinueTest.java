package simple;

public class ContinueTest {
    public static void main(String[] args) {
        for (var i = 0; i < 3; i++) {
            System.out.println("i的值是" + i);
            if (i == 1) {
                continue;
            }
            System.out.println("continue后的输出语句");
        }
    }
}
