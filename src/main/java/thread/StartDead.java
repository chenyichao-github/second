package thread;

public class StartDead extends Thread {
    private int i;

    public static void main(String[] args) {
        var sd = new StartDead();
        for (var i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                sd.start();
                System.out.println(sd.isAlive());
            }
            if (i > 20 && !sd.isAlive()) {
                sd.start();
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
