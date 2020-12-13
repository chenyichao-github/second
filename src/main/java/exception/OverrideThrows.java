package exception;

import java.io.FileInputStream;
import java.io.IOException;

public class OverrideThrows {
    public void test() throws IOException {
        var fis = new FileInputStream("a.txt");
    }
}

class Sub extends OverrideThrows {
    @Override
    public void test() throws IOException {
    }
}

