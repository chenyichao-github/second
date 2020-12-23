package network;

import java.io.IOException;

public class MultiThreadDown {
    public static void main(String[] args) throws IOException {
        final var downUtil = new DownUtil("https://softforspeed.51xiazai.cn/down/newdown/11/02/QQ_6.7.0.dmg", "QQ_6.7.0.dmg", 4);
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1) {
                System.out.println("ÒÑÍê³É£º" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                }
            }
        }).start();
    }
}
