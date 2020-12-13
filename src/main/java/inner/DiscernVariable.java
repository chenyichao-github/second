package inner;

public class DiscernVariable {
    private String prop = "外部类的实例变量";

    public static void main(String[] args) {
        new DiscernVariable().test();
    }

    public void test() {
        var in = new InClass();
        in.info();
    }

    private class InClass {
        private String prop = "内部类的实例变量";

        public void info() {
            var prop = "局部变量";
            System.out.println("外部类的实例变量值：" + DiscernVariable.this.prop);
            System.out.println("内部类的实例变量值：" + this.prop);
            System.out.println("局部变量的值：" + prop);
        }
    }
}
