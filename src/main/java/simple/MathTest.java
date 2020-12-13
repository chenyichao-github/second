package simple;

public class MathTest {
    public static void main(String[] args) {
        var a = 3.2;
        double b = Math.pow(a, 5);
        System.out.println(b);
        double c = Math.sqrt(a);
        System.out.println(c);
        double d = Math.random();
        System.out.println(d);
        double e = Math.sin(1.57);
        System.out.println(e);
        double x = -5.0;
        x = -x;
        System.out.println(x);
    }
}
