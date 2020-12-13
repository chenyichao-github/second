package simple;

public class ReferenceTransferTest {
    public static void swap(DataWrap dw) {
        var tmp = dw.a;
        dw.a = dw.b;
        dw.b = tmp;
        System.out.println("swap方法里，a成员变量的值是" + dw.a + "；b成员变量的值是" + dw.b);
        dw = null;
    }

    public static void main(String[] args) {
        var dw = new DataWrap();
        dw.a = 6;
        dw.b = 9;
        swap(dw);
        System.out.println("交换结束后，a成员变量的值是" + dw.a + "；b成员变量的值是" + dw.b);
    }
}

class DataWrap {
    int a;
    int b;
}
