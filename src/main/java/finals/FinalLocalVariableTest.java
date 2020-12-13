package finals;

public class FinalLocalVariableTest {
    public static void main(String[] args) {
        final var str = "hello";
        //str = "Java";
        final double d;
        d = 5.6;
        //55d = 3.4;
    }

    public void test(final int a) {
        //a = 5;
    }
}
