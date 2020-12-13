package simple;

public class Overload {
    public static void main(String[] args) {
        var ol = new Overload();
        ol.test();
        ol.test("hello");
    }

    public void test() {
        System.out.println("无参数");
    }

    public void test(String msg) {
        System.out.println("重载的test方法 " + msg);
    }
}
