package inner;

public class AccessStaticInnerClass {
    public static void main(String[] args) {
        new AccessStaticInnerClass().accessInnerProp();
    }

    public void accessInnerProp() {
        //System.out.println(prop1);
        System.out.println(StaticInnerClass.prop1);
        //System.out.println(prop2);
        System.out.println(new StaticInnerClass().prop2);
    }

    static class StaticInnerClass {
        private static int prop1 = 5;
        private int prop2 = 9;
    }
}
