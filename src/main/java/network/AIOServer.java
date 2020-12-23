package network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {
    static final int PORT = 30000;
    final static String UTF_8 = "utf-8";
    static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        var server = new AIOServer();
        server.startListen();
    }

    public void startListen() throws IOException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(channelGroup).bind(new InetSocketAddress(PORT));
        serverChannel.accept(null, new AcceptHandler(serverChannel));
        Thread.sleep(100000);
    }
}

class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    ByteBuffer buff = ByteBuffer.allocate(1024);
    private AsynchronousServerSocketChannel serverChannel;

    public AcceptHandler(AsynchronousServerSocketChannel sc) {
        this.serverChannel = sc;
    }

    @Override
    public void completed(final AsynchronousSocketChannel sc, Object attachment) {
        AIOServer.channelList.add(sc);
        serverChannel.accept(null, this);
        sc.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                String content = StandardCharsets.UTF_8.decode(buff).toString();
                for (AsynchronousSocketChannel c : AIOServer.channelList) {
                    try {
                        c.write(ByteBuffer.wrap(content.getBytes(StandardCharsets.UTF_8))).get();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                buff.clear();
                sc.read(buff, null, this);
            }

            @Override
            public void failed(Throwable ex, Object attachment) {
                System.out.println("读取数据失败：" + ex);
                AIOServer.channelList.remove(sc);
            }
        });
    }

    @Override
    public void failed(Throwable ex, Object attachment) {
        System.out.println("连接失败：" + ex);
    }
}
