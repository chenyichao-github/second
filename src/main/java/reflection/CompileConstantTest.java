package reflection;

class MyTest {
    static final String compileConstant = System.currentTimeMillis() + "";

    static {
        System.out.println("��̬��ʼ����...");
    }
}

public class CompileConstantTest {
    public static void main(String[] args) {
        System.out.println(MyTest.compileConstant);
    }
}
