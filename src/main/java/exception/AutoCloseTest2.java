package exception;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AutoCloseTest2 {
    public static void main(String[] args) throws IOException {
        final var br = new BufferedReader(new FileReader("src/main/java/exception/AutoCloseTest.java"));
        var ps = new PrintStream(new FileOutputStream("src/main/java/exception/a.txt"));
        try (br; ps) {
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }
}
