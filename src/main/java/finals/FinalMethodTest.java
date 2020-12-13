package finals;

public class FinalMethodTest {
    private final void test() {
    }
}

class Sub extends FinalMethodTest {
    public static void main(String[] args) {
        new Sub();
    }

    public void test() {
    }
}

