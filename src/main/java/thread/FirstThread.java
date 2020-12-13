package thread;

public class FirstThread extends Thread {
    private int i;

    public static void main(String[] args) {
        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}
