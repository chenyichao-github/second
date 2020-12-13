package lee.sub.test.print;

public class EqualTest {
    public static void main(String[] args) {
        var it = 65;
        var fl = 65.0f;
        System.out.println("65和65.0f是否相等？" + (it == fl));
        var ch = 'A';
        System.out.println("65和'A'是否相等？" + (it == ch));
        var str1 = "hello";
        var str2 = "hello";
        System.out.println("str1和str2是否相等？" + (str1 == str2));
        System.out.println("str1是否equals str2？" + (str1.equals(str2)));
        //System.out.println("hello" == new EqualTest());
    }
}
