package com.meizhuo.NettyTest._1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/26 13:31
 * @UpdateUser:
 * @UpdateDate: 2018/9/26 13:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class NIOService {
    public static void main(String[] args) throws IOException {
        Selector serviceSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(() -> {

            try {
                //对应IO编程中服务端的启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(8000));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serviceSelector, SelectionKey.OP_ACCEPT);

                while (true) {
                    //监听是否有新的连接，1表示阻塞的时间是1ms
                    if (serviceSelector.select(1) > 0) {
                        Set<SelectionKey> set = serviceSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = set.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            if (key.isAcceptable()) {
                                try {
                                    //每来一个连接，不需要创建一个线程，而是直接注册一个线程到clientSelector
                                    SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                } finally {
                                    iterator.remove();
                                }
                            }
                        }
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                //批量轮训是否有哪些连接数据可读，1表示阻塞时间为1ms
                try {
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = set.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            if (key.isReadable()) {
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    //以数据块为单位批量读取
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());

                                } finally {
                                    iterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();


    }
}
