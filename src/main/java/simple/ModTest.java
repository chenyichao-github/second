package simple;

public class ModTest {
    public static void main(String[] args) {
        var a = 5.2;
        var b = 3.1;
        var mod = a % b;
        System.out.println(mod);
        System.out.println("5对0.0求余的结果是:" + 5 % 0.0);
        System.out.println("-5.0对0求余的结果是:" + -5.0 % 0);
        System.out.println("0对5.0求余的结果是:" + 0 % 5.0);
        System.out.println("0对0.0求余的结果是:" + 0 % 0.0);
        //System.out.println("-5对0求余的结果是:" + -5 % 0);
        var m = 5;
        var n = m++ + 6;
        System.out.println(m + "\n" + n);
        var q = 5;
        var h = ++q + 6;
        System.out.println(q + "\n" + h);
    }
}
