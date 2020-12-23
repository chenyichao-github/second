package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class GetPostTest {
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            var realUrl = new URL(urlName);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (var key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            try (
                    var in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    public static String sendPost(String url, String param) {
        String result = "";
        try {
            var realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            try (
                    var out = new PrintStream(conn.getOutputStream())
            ) {
                out.println(param);
                out.flush();
            }
            try (
                    var in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = GetPostTest.sendGet("http://localhost:8888/abc/a.jsp", null);
        System.out.println(s);
        String s1 = GetPostTest.sendPost("http://localhost:8888/abc/login.jsp", "name=crazyit.org&pass=leegang");
        System.out.println(s1);
    }
}
