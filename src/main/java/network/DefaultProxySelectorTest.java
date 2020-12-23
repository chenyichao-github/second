package network;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

public class DefaultProxySelectorTest {
    static String urlStr = "http://www.crazyit.org";

    public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();
        props.setProperty("http.proxyHost", "192.168.10.96");
        props.setProperty("http.proxyPort", "8080");
        props.setProperty("http.nonProxyHosts", "localhost|192.168.10.*");
        props.setProperty("https.proxyHost", "192.168.10.96");
        props.setProperty("https.proxyPort", "443");
        props.setProperty("ftp.proxyHost", "192.168.10.96");
        props.setProperty("ftp.proxyPort", "2121");
        props.setProperty("ftp.nonProxyHosts", "localhost|192.168.10.*");
        props.setProperty("socks.ProxyHost", "192.168.10.96");
        props.setProperty("socks.ProxyPort", "1080");
        ProxySelector selector = ProxySelector.getDefault();
        System.out.println("系统默认的代理选择器：" + selector);
        System.out.println("系统为ftp://www.crazyit.org选择的代理服务器为：" + ProxySelector.getDefault().select(new URI("ftp://www.crazyit.org")));
        var url = new URL(urlStr);
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(3000);
        try (var scan = new Scanner(conn.getInputStream(), "GBK")) {
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        }
    }
}
