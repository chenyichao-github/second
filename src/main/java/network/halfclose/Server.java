package network.halfclose;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {
        var ss = new ServerSocket(30000);
        Socket socket = ss.accept();
        var ps = new PrintStream(socket.getOutputStream());
        ps.println("服务器的第一行数据");
        ps.println("服务器的第二行数据");
        socket.shutdownOutput();
        System.out.println(socket.isClosed());
        var scan = new Scanner(socket.getInputStream());
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
        socket.close();
        ss.close();
    }
}
