package thread;

public class DaemonThread extends Thread {
    public static void main(String[] args) {
        var t = new DaemonThread();
        t.setDaemon(true);
        t.start();
        for (var i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    @Override
    public void run() {
        for (var i = 0; i < 1000; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}
