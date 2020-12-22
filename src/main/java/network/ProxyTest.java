package network;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ProxyTest {
    final String PROXY_ADDR = "129.82.12.188";
    final int PROXY_PORT = 3124;
    String urlStr = "https://www.baidu.com";

    public static void main(String[] args) throws IOException {
        new ProxyTest().init();
    }

    public void init() throws IOException {
        var url = new URL(urlStr);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
        URLConnection conn = url.openConnection(proxy);
        conn.setConnectTimeout(3000);
        try (
                var scan = new Scanner(conn.getInputStream());
                var ps = new PrintStream("index.htm")
        ) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
                ps.println(line);
            }
        }
    }
}
