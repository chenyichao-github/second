package inner;

public class VarInLambda {
    public static void main(String[] args) {
        var run = (Runnable) () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println();
            }
        };
    }
}
