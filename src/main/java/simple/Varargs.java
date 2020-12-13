package simple;

public class Varargs {
    public static void test(int a, String... books) {
        for (var tmp : books) {
            System.out.println(tmp);
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        test(5, "疯狂Java讲义", "轻量级Java EE企业应用实战");
    }
}
