package thread;

import java.util.concurrent.FutureTask;

public class ThirdThread {
    public static void main(String[] args) {
        var rt = new ThirdThread();
        FutureTask<Integer> task = new FutureTask<>(() -> {
            var i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "的循环变量i的值：" + i);
            }
            return i;
        });
        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值：" + i);
            if (i == 20) {
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
