package lee;

public class BlockTest {
    public static void main(String[] args) {
        {
            int a;
            a = 5;
            System.out.println("代码块局部变量a的值:" + a);
        }
        //System.out.println(a);
    }
}
