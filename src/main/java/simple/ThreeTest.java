package simple;

public class ThreeTest {
    public static void main(String[] args) {
        String str = 5 > 3 ? "5大于3" : "5不大于3";
        System.out.println(str);
        String str2 = null;
        if (5 > 3) {
            System.out.println("5大于3");
        } else {
            System.out.println("5不大于3");
        }
        var a = 11;
        var b = 12;
        System.out.println(a > b ? "a大于b" : (a < b ? "a小于b" : "a等于b"));
    }
}
