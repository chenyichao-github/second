package simple;

public class ForErrorTest {
    public static void main(String[] args) {
        for (var count = 0; count < 10; count++) {
            System.out.println(count);
            count *= 0.1;
        }
        System.out.println("循环结束!");
    }
}
