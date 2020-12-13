package objects;

import java.util.Objects;

class Bar {
}

class Foo {
    Bar bar;

    public Foo(Bar bar) {
        this.bar = Objects.requireNonNull(bar);
    }
}

public class ObjectsTest {
    static ObjectsTest obj;

    public static void main(String[] args) {
        System.out.println(Objects.hashCode(obj));
        System.out.println(obj);
        System.out.println(Objects.requireNonNull(obj, "obj参数不能是null！"));
    }
}
