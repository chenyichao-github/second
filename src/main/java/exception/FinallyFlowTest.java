package exception;

public class FinallyFlowTest {
    public static void main(String[] args) {
        boolean b = test();
        System.out.println(b);
    }

    public static boolean test() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
