package network.halfclose;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        var s = new Socket("127.0.0.1", 30000);
        var scan = new Scanner(s.getInputStream());
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        var ps = new PrintStream(s.getOutputStream());
        ps.println("�ͻ��˵ĵ�һ������");
        ps.println("�ͻ��˵ĵڶ�������");
        ps.close();
        scan.close();
        s.close();
    }
}
