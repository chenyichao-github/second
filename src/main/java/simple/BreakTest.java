package simple;

public class BreakTest {
    public static void main(String[] args) {
        for (var i = 0; i < 10; i++) {
            System.out.println("i的值是:" + i);
            if (i == 2) {
                break;
            }
        }
    }
}
