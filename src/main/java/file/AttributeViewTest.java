package file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

public class AttributeViewTest {
    public static void main(String[] args) throws IOException {
        Path testPath = Paths.get("src/main/java/file/AttributeViewTest.java");
        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = basicView.readAttributes();
        System.out.println("����ʱ�䣺" + new Date(basicFileAttributes.creationTime().toMillis()));
        System.out.println("������ʱ�䣺" + new Date(basicFileAttributes.lastAccessTime().toMillis()));
        System.out.println("����޸�ʱ�䣺" + new Date(basicFileAttributes.lastModifiedTime().toMillis()));
        System.out.println("�ļ���С��" + basicFileAttributes.size());
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
        System.out.println(ownerView.getOwner());
        UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("root");
        //ownerView.setOwner(user);
        /*UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
        userView.write("������", Charset.defaultCharset().encode("���Java����"));
        List<String> attrNames = userView.list();
        for (var name : attrNames) {
            ByteBuffer buf = ByteBuffer.allocate(userView.size(name));
            userView.read(name, buf);
            buf.flip();
            String value = Charset.defaultCharset().decode(buf).toString();
            System.out.println(name + "--->" + value);
        }*/
        /*DosFileAttributeView dosView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);
        dosView.setHidden(true);
        dosView.setReadOnly(true);*/
    }
}
