package method;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    private static void hello() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) throws Throwable {
        var type = MethodType.methodType(void.class);
        var mtd = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", type);
        mtd.invoke();
        var mtd1 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello", MethodType.methodType(String.class, String.class));
        System.out.println(mtd1.invoke(new MethodHandleTest(), "孙悟空"));
    }

    private String hello(String name) {
        System.out.println("执行带参数的hello" + name);
        return name + ",您好";
    }
}
