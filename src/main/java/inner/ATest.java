package inner;

interface A {
    void test();
}

public class ATest {
    public static void main(String[] args) {
        int age = 8;
        //age = 2;
        var a = new A() {

            @Override
            public void test() {
                System.out.println(age);
            }
        };
        a.test();
    }
}
