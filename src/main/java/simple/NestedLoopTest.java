package simple;

public class NestedLoopTest {
    public static void main(String[] args) {
        for (var i = 0; i < 5; i++) {
            for (var j = 0; j < 3; j++) {
                System.out.println("i的值为:" + i + " j的值为:" + j);
            }
        }
    }
}
