package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

public class FilterTest {
    public static void main(String[] args) {
        try (
                var ois = new ObjectInputStream(new FileInputStream("object.txt"))
        ) {
            ois.setObjectInputFilter(info -> {
                System.out.println("===执行数据过滤===");
                ObjectInputFilter serialFilter = ObjectInputFilter.Config.getSerialFilter();
                if (serialFilter != null) {
                    ObjectInputFilter.Status status = serialFilter.checkInput(info);
                    if (status != ObjectInputFilter.Status.UNDECIDED) {
                        return status;
                    }
                }
                if (info.references() != 1) {
                    return ObjectInputFilter.Status.REJECTED;
                }
                if (info.serialClass() != null && info.serialClass() != Person.class) {
                    return ObjectInputFilter.Status.REJECTED;
                }
                return ObjectInputFilter.Status.UNDECIDED;
            });
            var p = (Person) ois.readObject();
            System.out.println("名字为：" + p.getName() + "\n年龄为：" + p.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
