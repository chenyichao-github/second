package inner;

@FunctionalInterface
interface FkTest {
    void run();
}

public class LambdaTest {
    Runnable r = () -> {
        for (var i = 0; i < 100; i++) {
            System.out.println();
        }
    };
    /*Object obj = () -> {
        for (var i = 0; i < 100; i++) {
            System.out.println();
        }
    };*/
    Object obj1 = (Runnable) () -> {
        for (var i = 0; i < 100; i++) {
            System.out.println();
        }
    };
    Object obj2 = (FkTest) () -> {
        for (var i = 0; i < 100; i++) {
            System.out.println();
        }
    };
}
