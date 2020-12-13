package thread;

public class InvokeRun extends Thread {
    private int i;

    public static void main(String[] args) {
        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + i);
    }
}
