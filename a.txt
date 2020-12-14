package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
    public static void main(String[] args) throws IOException {
        Files.copy(Paths.get("src/main/java/file/FilesTest.java"), new FileOutputStream("a.txt"));
        System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(Paths.get("src/main/java/file/FilesTest.java")));
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/file/FilesTest.java"), Charset.forName("GBK"));
        System.out.println(lines);
        System.out.println("FilesTest.java的大小为：" + Files.size(Paths.get("src/main/java/file/FilesTest.java")));
        List<String> poem = new ArrayList<>();
        poem.add("水晶潭底银鱼跃");
        poem.add("清徐风中碧竿横");
        Files.write(Paths.get("poem.txt"), poem, Charset.forName("GBK"));
        Files.list(Paths.get(".")).forEach(System.out::println);
        Files.lines(Paths.get("src/main/java/file/FilesTest.java"), Charset.forName("GBK")).forEach(System.out::println);
        FileStore cStore = Files.getFileStore(Paths.get("/"));
        System.out.println("共有空间：" + cStore.getTotalSpace());
        System.out.println("可用空间：" + cStore.getUsableSpace());
    }
}
