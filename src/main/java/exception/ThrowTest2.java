package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowTest2 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            new FileInputStream("a.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
