package com.meizhuo.NettyTest._4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/26 21:49
 * @UpdateUser:
 * @UpdateDate: 2018/9/26 21:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class NettyServer {
    public static void main(String[] args) {
        //负责接收连接
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //负责处理每个连接
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                //绑定两大线程组，定型线程模型
                .group(bossGroup,workerGroup)
                //指定服务端的IO模型为NIO
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        //对每条连接进行数据读写，业务处理逻辑
                    }
                });
        serverBootstrap.bind(8000);

    }
}
