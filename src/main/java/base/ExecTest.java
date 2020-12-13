package base;

import java.io.IOException;

public class ExecTest {
    public static void main(String[] args) throws IOException {
        var rt = Runtime.getRuntime();
        rt.exec("open -n /Applications/QQMusic.app");
    }
}
