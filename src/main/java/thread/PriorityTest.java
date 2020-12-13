package thread;

import org.jetbrains.annotations.NotNull;

public class PriorityTest extends Thread {
    public PriorityTest(@NotNull String name) {
        super(name);
    }

    public static void main(String[] args) {
        Thread.currentThread().setPriority(6);
        for (var i = 0; i < 30; i++) {
            if (i == 10) {
                var low = new PriorityTest("低级");
                low.start();
                System.out.println("创建之初的优先级：" + low.getPriority());
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (i == 20) {
                var high = new PriorityTest("高级");
                high.start();
                System.out.println("创建之初的优先级：" + high.getPriority());
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }

    @Override
    public void run() {
        for (var i = 0; i < 50; i++) {
            System.out.println(getName() + ",其优先级是：" + getPriority() + ",循环变量的值为：" + i);
        }
    }
}
