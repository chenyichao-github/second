package thread;

public class SecondThread implements Runnable {
    private int i;

    public static void main(String[] args) {
        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                var st = new SecondThread();
                new Thread(st, "新线程1").start();
                new Thread(st, "新线程2").start();
                //var st = new SecondThread();
                //new Thread(st, "xxx");
            }
        }
    }

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
