package network.NoBlock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NServer {
    static final int PORT = 30000;
    private Selector selector = null;
    private Charset charset = Charset.forName("GBK");

    public static void main(String[] args) throws IOException {
        new NServer().init();
    }

    public void init() throws IOException {
        selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        var isa = new InetSocketAddress("127.0.0.1", PORT);
        server.bind(isa);
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            for (SelectionKey sk : selector.selectedKeys()) {
                selector.selectedKeys().remove(sk);
                if (sk.isAcceptable()) {
                    SocketChannel sc = server.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }
                if (sk.isReadable()) {
                    var sc = (SocketChannel) sk.channel();
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    var content = "";
                    try {
                        while (sc.read(buff) > 0) {
                            buff.flip();
                            content += charset.decode(buff);
                        }
                        System.out.println("读取的数据：" + content);
                        sk.interestOps(SelectionKey.OP_READ);
                    } catch (IOException ex) {
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
                    }
                    if (content.length() > 0) {
                        for (SelectionKey key : selector.selectedKeys()) {
                            Channel targetChannel = key.channel();
                            if (targetChannel instanceof SocketChannel) {
                                var dest = (SocketChannel) targetChannel;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }
        }
    }
}
