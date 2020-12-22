package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSocketTest implements Runnable {
    public static final int BROADCAST_PORT = 30000;
    private static final String BROADCAST_IP = "230.0.0.1";
    private static final int DATA_LEN = 4096;
    byte[] inBuff = new byte[DATA_LEN];
    private MulticastSocket socket = null;
    private InetAddress broadcastAddress = null;
    private Scanner scan = null;
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outPacket = null;

    public static void main(String[] args) throws IOException {
        new MulticastSocketTest().init();
    }

    public void init() throws IOException {
        try (var scan = new Scanner(System.in)) {
            socket = new MulticastSocket(BROADCAST_PORT);
            broadcastAddress = InetAddress.getByName(BROADCAST_IP);
            socket.joinGroup(broadcastAddress);
            socket.setLoopbackMode(false);
            outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
            new Thread(this).start();
            while (scan.hasNextLine()) {
                byte[] buff = scan.nextLine().getBytes();
                outPacket.setData(buff);
                socket.send(outPacket);
            }
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                socket.receive(inPacket);
                System.out.println("¡ƒÃÏ–≈œ¢£∫" + new String(inBuff, 0, inPacket.getLength()));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            try {
                if (socket != null) {
                    socket.leaveGroup(broadcastAddress);
                    socket.close();
                }
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
