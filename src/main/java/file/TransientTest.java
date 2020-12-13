package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
    public static void main(String[] args) {
        try (
                var oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
                var ois = new ObjectInputStream(new FileInputStream("transient.txt"))
        ) {
            var per = new Person1("孙悟空", 500);
            oos.writeObject(per);
            var p = (Person1) ois.readObject();
            System.out.println(p.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
