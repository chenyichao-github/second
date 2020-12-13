package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BigPersonTest {
    public static void main(String[] args) {
        try (
                var oos = new ObjectOutputStream(new FileOutputStream("BigPerson.txt"));
                var ois = new ObjectInputStream(new FileInputStream("BigPerson.txt"))
        ) {
            var per = new BigPerson("孙悟空", 500);
            oos.writeObject(per);
            var p = (BigPerson) ois.readObject();
            System.out.println(p.getName() + p.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
