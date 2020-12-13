package regex;

import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        var str = "hello , java!";
        System.out.println(str.replaceFirst("\\w*", "..."));
        System.out.println(str.replaceFirst("\\w*?", "..."));
        boolean b = Pattern.matches("a*b", "aaaaaaaaab");
        System.out.println(b);
    }
}
