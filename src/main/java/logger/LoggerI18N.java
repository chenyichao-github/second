package logger;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerI18N {
    public static void main(String[] args) throws IOException {
        var rb = ResourceBundle.getBundle("logMess", Locale.getDefault(Locale.Category.FORMAT));
        var logger = System.getLogger("fkjava", rb);
        Logger.getLogger("fkjava").setLevel(Level.INFO);
        Logger.getLogger("fkjava").addHandler(new FileHandler("src/main/java/logger/a.xml"));
        logger.log(System.Logger.Level.DEBUG, "debug");
        logger.log(System.Logger.Level.INFO, "info");
        logger.log(System.Logger.Level.ERROR, "error");
    }
}
