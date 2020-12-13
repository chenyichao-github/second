package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReplaceTest {
    public static void main(String[] args) {
        try (
                var oos = new ObjectOutputStream(new FileOutputStream("replace.txt"));
                var ois = new ObjectInputStream(new FileInputStream("replace.txt"))
        ) {
            var per = new BestPerson("孙悟空", 500);
            oos.writeObject(per);
            var list = (ArrayList) ois.readObject();
            System.out.println(list);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
