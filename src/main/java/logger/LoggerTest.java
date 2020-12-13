package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
    public static void main(String[] args) throws IOException {
        var logger = System.getLogger("fkjava");
        Logger.getLogger("fkjava").setLevel(Level.FINE);
        Logger.getLogger("fkjava").addHandler(new FileHandler("src/main/java/logger/a.xml"));
        logger.log(System.Logger.Level.DEBUG, "debug信息");
        logger.log(System.Logger.Level.INFO, "info信息");
        logger.log(System.Logger.Level.ERROR, "error信息");
    }
}
