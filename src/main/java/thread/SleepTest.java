package thread;

import java.util.Date;

public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        for (var i = 0; i < 100; i++) {
            System.out.println("当前时间：" + new Date());
            Thread.sleep(1000);
        }
    }
}
