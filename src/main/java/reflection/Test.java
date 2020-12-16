package reflection;

public class Test {
    static int a = 5;
    static int b = 9;
    static int c;

    static {
        b = 6;
        System.out.println("---------");
    }

    public static void main(String[] args) {
        System.out.println(Test.b);
    }
}
