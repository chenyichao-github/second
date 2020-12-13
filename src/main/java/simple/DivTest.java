package simple;

public class DivTest {
    public static void main(String[] args) {
        var a = 5.2;
        var b = 3.1;
        var div = a / b;
        System.out.println(div);
        System.out.println("5除以0.0的结果是:" + 5 / 0.0);
        System.out.println("-5除以0.0的结果是:" + -5 / 0.0);
        System.out.println("-5除以0的结果是:" + -5 / 0);
    }
}
