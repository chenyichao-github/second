package reflection;

public class ATest1 {
    public static void main(String[] args) {
        var a = new A();
        A.a++;
        System.out.println(A.a);
    }
}
