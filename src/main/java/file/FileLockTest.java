package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (var channel = new FileOutputStream("a.txt").getChannel()) {
            FileLock lock = channel.tryLock();
            Thread.sleep(10000);
            lock.release();
        }
    }
}
