package simple;

public class BreakLabel {
    public static void main(String[] args) {
        outer:
        for (var i = 0; i < 5; i++) {
            for (var j = 0; j < 3; j++) {
                System.out.println("i的值为:" + i + " j的值为:" + j);
                if (j == 1)
                    break outer;
            }
        }
    }
}
