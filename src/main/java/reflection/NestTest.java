package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class NestTest {
    public static void main(String[] args) throws Exception {
        new NestTest().info();
        System.out.println(NestTest.class.getNestHost());
        System.out.println(Class.forName("reflection.NestTest$InA").getNestHost());
        System.out.println(Arrays.toString(NestTest.class.getNestMembers()));
        System.out.println(Class.forName("reflection.NestTest$InA").isNestmateOf(Class.forName("reflection.NestTest$InB")));
    }

    public void info() throws Exception {
        InB b = new InB();
        b.name = "crazyit.org";
        System.out.println(b.name);
        b.bar();
        Field f = InB.class.getDeclaredField("name");
        f.set(b, "fkjava.org");
        System.out.println(f.get(b));
        Method m = InB.class.getDeclaredMethod("bar");
        m.invoke(b);
    }

    public class InA {
        private int age = 2;

        private void foo() {
            System.out.println("private的foo方法");
        }
    }

    public class InB {
        private String name = "疯狂Java";

        private void bar() throws Exception {
            InA a = new InA();
            a.age = 20;
            System.out.println(a.age);
            a.foo();
            System.out.println("private的bar方法");
            Field f = InA.class.getDeclaredField("age");
            f.set(a, 29);
            System.out.println(f.get(a));
            Method m = InA.class.getDeclaredMethod("foo");
            m.invoke(a);
        }
    }
}
