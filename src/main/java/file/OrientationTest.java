package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OrientationTest {
    public static void main(String[] args) {
        try (
                var oos = new ObjectOutputStream(new FileOutputStream("Orientation.txt"));
                var ois = new ObjectInputStream(new FileInputStream("Orientation.txt"))
        ) {
            oos.writeObject(Orientation.HORIZONTAL);
            var ori = (Orientation) ois.readObject();
            System.out.println(ori == Orientation.HORIZONTAL);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
