package network;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProxySelectorTest {
    final String PROXY_ADDR = "139.82.12.188";
    final int PROXY_PORT = 3124;
    String urlStr = "http://www.crazyit.org";

    public static void main(String[] args) throws IOException {
        new ProxySelectorTest().init();
    }

    public void init() throws IOException {
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                List<Proxy> result = new ArrayList<>();
                result.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT)));
                return result;
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                System.out.println("无法连接到指定代理服务器！");
            }
        });
        var url = new URL(urlStr);
        URLConnection conn = url.openConnection();
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
