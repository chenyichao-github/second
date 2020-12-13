package enums;

public class GcTest {
    public static void main(String[] args) {
        for (var i = 0; i < 4; i++) {
            new GcTest();
        }
        //System.gc();
        Runtime.getRuntime().gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("系统正在清理GcTest对象的资源...");
    }
}
