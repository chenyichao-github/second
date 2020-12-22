package network.LanTalk;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class ComUtil {
    public static final String CHARSET = "GBK";
    public static final int BROADCAST_PORT = 30000;
    private static final String BROADCAST_IP = "230.0.0.1";
    private static final int DATA_LEN = 4096;
    byte[] inBuff = new byte[DATA_LEN];
    private MulticastSocket socket = null;
    private DatagramSocket singleSocket = null;
    private InetAddress broadcastAddress = null;
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outPacket = null;
    private LanTalk lanTalk;

    public ComUtil(LanTalk lanTalk) throws Exception {
        this.lanTalk = lanTalk;
        socket = new MulticastSocket(BROADCAST_PORT);
        singleSocket = new DatagramSocket(BROADCAST_PORT + 1);
        broadcastAddress = InetAddress.getByName(BROADCAST_IP);
        socket.joinGroup(broadcastAddress);
        socket.setLoopbackMode(false);
        outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
        new ReadBroad().start();
        Thread.sleep(1);
        new ReadSingle().start();
    }

    public void broadCast(String msg) {
        try {
            byte[] buff = msg.getBytes(CHARSET);
            outPacket.setData(buff);
            socket.send(outPacket);
        } catch (IOException ex) {
            ex.printStackTrace();
            if (socket != null) {
                socket.close();
            }
            JOptionPane.showMessageDialog(null, "发送信息异常，请确认30000端口空闲，且网络连接正常！", "网络异常", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void sendSingle(String msg, SocketAddress dest) {
        try {
            byte[] buff = msg.getBytes(CHARSET);
            var packet = new DatagramPacket(buff, buff.length, dest);
            singleSocket.send(packet);
        } catch (IOException ex) {
            ex.printStackTrace();
            if (singleSocket != null) {
                singleSocket.close();
            }
            JOptionPane.showMessageDialog(null, "发送信息异常，请确认30001端口空闲，且网络连接正常！", "网络异常", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    class ReadSingle extends Thread {
        byte[] singleBuff = new byte[DATA_LEN];
        private DatagramPacket singlePacket = new DatagramPacket(singleBuff, singleBuff.length);

        @Override
        public void run() {
            while (true) {
                try {
                    singleSocket.receive(singlePacket);
                    lanTalk.processMsg(singlePacket, true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    if (singleSocket != null) {
                        singleSocket.close();
                    }
                    JOptionPane.showMessageDialog(null, "接收信息异常，请确认30001端口空闲，且网络连接正常！", "网络异常", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            }
        }
    }

    class ReadBroad extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    socket.receive(inPacket);
                    var msg = new String(inBuff, 0, inPacket.getLength(), CHARSET);
                    if (msg.startsWith(YeekuProtocol.PRESENCE) && msg.endsWith(YeekuProtocol.PRESENCE)) {
                        String userMsg = msg.substring(2, msg.length() - 2);
                        String[] userInfo = userMsg.split(YeekuProtocol.SPLITTER);
                        var user = new UserInfo(userInfo[1], userInfo[0], inPacket.getSocketAddress(), 0);
                        var addFlag = true;
                        ArrayList<Integer> delList = new ArrayList<>();
                        for (var i = 1; i < lanTalk.getUserNum(); i++) {
                            UserInfo current = lanTalk.getUser(i);
                            current.setLost(current.getLost() + 1);
                            if (current.equals(user)) {
                                current.setLost(0);
                                addFlag = false;
                            }
                            if (current.getLost() > 2) {
                                delList.add(i);
                            }
                        }
                        for (var i = 0; i < delList.size(); i++) {
                            lanTalk.removeUser(delList.get(i));
                        }
                        if (addFlag) {
                            lanTalk.addUser(user);
                        }
                    } else {
                        lanTalk.processMsg(inPacket, false);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    if (socket != null) {
                        socket.close();
                    }
                    JOptionPane.showMessageDialog(null, "接收信息异常，请确认30000端空闲，且网络连接正常！", "网络异常", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            }
        }
    }
}

