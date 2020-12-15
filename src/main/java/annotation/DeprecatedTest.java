package annotation;

class Apple1 {
    @Deprecated(since = "9", forRemoval = true)
    public void info() {
        System.out.println("AppleµÄinfo·½·¨");
    }
}

public class DeprecatedTest {
    public static void main(String[] args) {
        //new Apple1().info();
    }
}
