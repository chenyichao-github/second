package simple;

public class PrimitiveTransferTest {
    public static void swap(int a, int b) {
        var tmp = a;
        a = b;
        b = tmp;
        System.out.println("swap方法里，a的值是" + a + "；b的值是" + b);
    }

    public static void main(String[] args) {
        var a = 6;
        var b = 9;
        swap(a, b);
        System.out.println("交换结束后，变量a的值是" + a + "；变量b的值是" + b);
    }
}
