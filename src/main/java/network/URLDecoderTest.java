package network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLDecoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82java", StandardCharsets.UTF_8);
        System.out.println(keyWord);
        String urlStr = URLEncoder.encode("疯狂Android讲义", "GBK");
        System.out.println(urlStr);
    }
}
