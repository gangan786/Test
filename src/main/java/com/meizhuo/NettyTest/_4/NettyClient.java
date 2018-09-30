package com.meizhuo.NettyTest._4;

import com.meizhuo.NettyTest._8.ClientHandle;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Date;
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
                        ch.pipeline().addLast(new ClientHandle());
                    }
                });
        connect(bootstrap, "127.0.0.1", 8000, MAX_RETRY);
    }


    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap
                .connect(host, port)
                .addListener(future -> {
                    if (future.isSuccess()) {
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

}
