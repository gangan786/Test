package com.meizhuo.NettyTest._13;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._13
 * @ClassName: ${TYPE_NAME}
 * @Description: 探究ChannelHandle的生命周期
 * @Author: Gangan
 * @CreateDate: 2018/10/3 20:42
 * @UpdateUser:
 * @UpdateDate: 2018/10/3 20:42
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LifeCycleTestHandle extends ChannelInboundHandlerAdapter {
    /**
     * 可用于资源的申请
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("处理器逻辑被添加：handleAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel绑定线程（NIOEventLoop）：channelRegistered");
        super.channelRegistered(ctx);
    }

    /**
     * 表明TCP连接的建立
     * 统计单机的连接数
     * 客户端ip黑白名单的过滤
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel准备就绪：channelActive");
        super.channelActive(ctx);
    }

    /**
     * 可在这里进行粘包拆包的操作
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channel有数据可读：channelRead");
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel某次数据读取完毕：channelReadComplete");
        super.channelReadComplete(ctx);
    }

    /**
     * 可用于资源的释放
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel被关闭：channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel取消线程（NIOEventLoop）的绑定：channelUnregistered");
        super.channelUnregistered(ctx);
    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("逻辑处理器被移除：handlerRemoved");
        super.handlerRemoved(ctx);
    }
}
