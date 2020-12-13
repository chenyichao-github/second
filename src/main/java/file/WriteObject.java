package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        try (
                var oos = new ObjectOutputStream(new FileOutputStream("object.txt"))
        ) {
            var per = new Person("孙悟空", 500);
            oos.writeObject(per);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
