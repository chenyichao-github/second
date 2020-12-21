package network.senior;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;

public class Server {
    private static final int SERVER_PORT = 30000;
    public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();

    public static void main(String[] args) {
        var server = new Server();
        server.init();
    }

    public void init() {
        try (var ss = new ServerSocket(SERVER_PORT)) {
            while (true) {
                var socket = ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("����������ʧ�ܣ��Ƿ�˿�" + SERVER_PORT + "�ѱ�ռ�ã�");
        }
    }
}
