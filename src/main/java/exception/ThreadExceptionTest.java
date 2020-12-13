package exception;

public class ThreadExceptionTest implements Runnable {
    public static void main(String[] args) {
        new Thread(new ThreadExceptionTest()).start();
    }

    @Override
    public void run() {
        firstMethod();
    }

    public void firstMethod() {
        secondMethod();
    }

    public void secondMethod() {
        var a = 5;
        var b = 0;
        var c = a / b;
    }
}
