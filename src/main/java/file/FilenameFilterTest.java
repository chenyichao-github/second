package file;

import java.io.File;

public class FilenameFilterTest {
    public static void main(String[] args) {
        var file = new File(".");
        var curFile = new File(file.getAbsoluteFile() + "/src/main/java/file");
        String[] nameList = curFile.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
        for (var name : nameList) {
            System.out.println(name);
        }
    }
}
