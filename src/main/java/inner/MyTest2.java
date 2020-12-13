package inner;

public class MyTest2 {
    public static void main(String[] args) {
        MyTest mt = String::substring;
        String str = mt.test("Java I Love you", 2, 9);
        System.out.println(str);
    }
}
