package com.meizhuo.NettyTest._4;

import com.meizhuo.NettyTest._11.LoginResponseHandle;
import com.meizhuo.NettyTest._11.MessageResponHandle;
import com.meizhuo.NettyTest._11.PacketDecode;
import com.meizhuo.NettyTest._11.PacketEncoder;
import com.meizhuo.NettyTest._12.Spliter;
import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._16.Handle.*;
import com.meizhuo.NettyTest._16.Packet.JoinGroupResponsePacket;
import com.meizhuo.NettyTest._16.Packet.LogoutResponsePacket;
import com.meizhuo.NettyTest._16.console.ConsloeCommandManager;
import com.meizhuo.NettyTest._16.console.LoginConsoleCommand;
import com.meizhuo.NettyTest._7.LoginRequestPacket;
import com.meizhuo.NettyTest._7.PacketCodeC;
import com.meizhuo.NettyTest._8.ClientHandle;
import com.meizhuo.NettyTest._9.LoginUtil;
import com.meizhuo.NettyTest._9.MessageRequestPacket;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
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
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                //处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecode());
                        ch.pipeline().addLast(new LoginResponseHandle());
                        ch.pipeline().addLast(new LogoutResponseHandle());
                        ch.pipeline().addLast(new MessageResponHandle());
                        ch.pipeline().addLast(new CreateGroupResponseHandle());
                        ch.pipeline().addLast(new JoinGroupResponseHandle());
                        ch.pipeline().addLast(new QuitGroupResponseHandle());
                        ch.pipeline().addLast(new ListGroupMembersResponseHandle());
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
                        startConsoleManagerThread(channel);
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

        Scanner scanner = new Scanner(System.in);
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        new Thread(() -> {
            while (!Thread.interrupted()) {
                //判断是否登录，记住对channel标记的时候，要在同一端进行标记和读取操作，
                //比如你在Service端标记channel登录状态，Client端是获取不到你这个状态的
                //所以要在同一端标记这样才能获取到
                if (!SessionUtil.hasLogin(channel)) {
                    System.out.println("请输入用户名登录：");
                    String name = scanner.nextLine();
                    loginRequestPacket.setUserName(name);
                    loginRequestPacket.setPassword("gangan");

                    //发送登录数据包
                    channel.writeAndFlush(loginRequestPacket);
                    waitForLoginResponse();
                } else {
                    System.out.println("请分别输入用户id和信息内容（空格隔开）");
                    String toUserId = scanner.next();
                    String message = scanner.next();
                    channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
                }
            }
        }).start();
    }

    private static void startConsoleManagerThread(Channel channel) {
        ConsloeCommandManager consloeCommandManager = new ConsloeCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();

        Scanner scanner = new Scanner(System.in);
        new Thread(() -> {
            while (!Thread.interrupted()){
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);
                } else {
                    consloeCommandManager.exec(scanner,channel);
                }
            }
        }).start();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
