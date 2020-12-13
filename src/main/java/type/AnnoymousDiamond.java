package type;

interface Foo<T> {
    void test(T t);
}

public class AnnoymousDiamond {
    public static void main(String[] args) {
        Foo<String> f = new Foo<>() {
            @Override
            public void test(String t) {
                System.out.println("test方法的t参数为：" + t);
            }
        };
        Foo<?> fo = new Foo<>() {
            @Override
            public void test(Object t) {
                System.out.println("test方法的Object参数为：" + t);
            }
        };
        Foo<? extends Number> fn = new Foo<>() {
            @Override
            public void test(Number t) {
                System.out.println("test方法的Number参数为：" + t);
            }
        };
        f.test("你妈");
    }
}
