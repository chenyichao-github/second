package simple;

public class LogicOperatorTest {
    public static void main(String[] args) {
        System.out.println(!false);
        System.out.println(5 > 3 && '6' > 10);
        System.out.println(4 >= 5 || 'c' > 'a');
        System.out.println(4 >= 5 ^ 'c' > 'a');
        var a = 5;
        var b = 10;
        if (a > 4 | b++ > 10) {
            System.out.println("a的值是:" + a + "，b的值是:" + b);
        }
        var c = 5;
        var d = 10;
        if (c > 4 || d++ > 10) {
            System.out.println("c的值是:" + c + "，d的值是:" + d);
        }
    }
}
