package lee.sub.test;

public class InstanceInitTest {
    int a = 9;

    {
        a = 6;
    }

    public static void main(String[] args) {
        System.out.println(new InstanceInitTest().a);
    }
}
