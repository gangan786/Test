package com.meizhuo.NettyTest._4;

import com.meizhuo.NettyTest._11.LoginResponseHandle;
import com.meizhuo.NettyTest._11.MessageResponHandle;
import com.meizhuo.NettyTest._11.PacketDecode;
import com.meizhuo.NettyTest._11.PacketEncoder;
import com.meizhuo.NettyTest._7.PacketCodeC;
import com.meizhuo.NettyTest._8.ClientHandle;
import com.meizhuo.NettyTest._9.LoginUtil;
import com.meizhuo.NettyTest._9.MessageRequestPacket;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/27 13:52
 * @UpdateUser:
 * @UpdateDate: 2018/9/27 13:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class NettyClient {

    private static final int MAX_RETRY = 6;

    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                //指定线程模型
                .group(workerGroup)
                //指定IO类型为NIO
                .channel(NioSocketChannel.class)
                //处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new PacketDecode());
                        ch.pipeline().addLast(new LoginResponseHandle());
                        ch.pipeline().addLast(new MessageResponHandle());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });
        connect(bootstrap, "127.0.0.1", 8000, MAX_RETRY);
    }


    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap
                .connect(host, port)
                .addListener(future -> {
                    if (future.isSuccess()) {
                        Channel channel = ((ChannelFuture) future).channel();
                        startConsoleThread(channel);
                        System.out.println(host + "/" + port + "连接成功");
                    } else if (retry == 0) {
                        System.out.println("重试次数已用完，放弃连接");
                    } else {
                        //第几次重连
                        int order = MAX_RETRY - retry + 1;
                        //该次重连的间隔时间
                        int delay = 1 << order;
                        System.out.println(new Date() + ": 连接失败，第" + order + "次重连...");
                        bootstrap
                                .config()
                                //返回一开始设置的workerGroup
                                .group()
                                .schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
                    }
                });


    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()){
                //判断是否登录，记住对channel标记的时候，要在同一端进行标记和读取操作，
                //比如你在Service端标记channel登录状态，Client端是获取不到你这个状态的
                //所以要在同一端标记这样才能获取到
                if (LoginUtil.hasLogin(channel)){
                    System.out.println("请输入消息内容");
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();

                    MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
                    messageRequestPacket.setMessage(line);
                    ByteBuf buf = PacketCodeC.INSTANT.encode(channel.alloc(), messageRequestPacket);
                    channel.writeAndFlush(buf);
                }
            }
        }).start();
    }
}
