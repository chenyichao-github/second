package simple;

public class DoWhileTest {
    public static void main(String[] args) {
        var count2 = 20;
        do {
            System.out.println(count2++);
        } while (count2 < 10);
        System.out.println("循环结束！");
    }
}
