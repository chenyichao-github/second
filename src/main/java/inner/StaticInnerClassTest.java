package inner;

public class StaticInnerClassTest {
    private static int prop2 = 9;
    private int prop1 = 5;

    public static void main(String[] args) {
        new StaticInnerClass().accessOuterProp();
    }

    static class StaticInnerClass {
        private static int age;

        public void accessOuterProp() {
            //System.out.println(prop1);
            System.out.println(prop2);
        }
    }
}
