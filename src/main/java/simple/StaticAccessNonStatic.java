package simple;

public class StaticAccessNonStatic {
    public static void main(String[] args) {
        new StaticAccessNonStatic().info();
    }

    public void info() {
        System.out.println("简单的info方法");
    }
}
