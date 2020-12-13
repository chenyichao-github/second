package base;

public class IdentityHashCodeTest {
    public static void main(String[] args) {
        var s1 = "Hello";
        var s2 = "Hello";
        System.out.println(s1.hashCode() + "----" + s2.hashCode());
        System.out.println(System.identityHashCode(s1) + "----" + System.identityHashCode(s2));
        var s3 = "Java";
        var s4 = "Java";
        System.out.println(System.identityHashCode(s3) + "----" + System.identityHashCode(s4));
    }
}
