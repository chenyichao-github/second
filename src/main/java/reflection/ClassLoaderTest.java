package reflection;

class Tester {
    static {
        System.out.println("Tester��ľ�̬��ʼ����...");
    }
}

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        cl.loadClass("reflection.Tester");
        System.out.println("ϵͳ����Tester��");
        Class.forName("reflection.Tester");
    }
}
