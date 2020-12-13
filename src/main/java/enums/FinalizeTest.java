package enums;

public class FinalizeTest {
    private static FinalizeTest ft = null;

    public static void main(String[] args) {
        new FinalizeTest();
        System.gc();
        //Runtime.getRuntime().runFinalization();
        System.runFinalization();
        ft.info();
    }

    public void info() {
        System.out.println("测试资源清理的finalize方法");
    }

    @Override
    protected void finalize() throws Throwable {
        ft = this;
    }
}
