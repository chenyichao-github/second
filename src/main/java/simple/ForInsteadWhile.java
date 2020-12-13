package simple;

public class ForInsteadWhile {
    public static void main(String[] args) {
        int tmp = 0;
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
            tmp = i;
        }
        System.out.println(tmp);
        System.out.println("循环结束!");
    }
}
