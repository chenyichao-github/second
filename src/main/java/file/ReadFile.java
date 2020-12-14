package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        try (
                var fis = new FileInputStream("src/main/java/file/ReadFile.java");
                FileChannel fcin = fis.getChannel()
        ) {
            ByteBuffer bbuff = ByteBuffer.allocate(256);
            while (fcin.read(bbuff) != -1) {
                bbuff.flip();
                Charset charset = Charset.forName("GBK");
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer cbuff = decoder.decode(bbuff);
                System.out.println(cbuff);
                bbuff.clear();
            }
        }
    }
}
