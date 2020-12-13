package finals;

public class ImmutableStringTest {
    public static void main(String[] args) {
        var str1 = "Hello";
        var str2 = "Hello";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
