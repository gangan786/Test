package com.meizhuo.NettyTest._4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/28 18:24
 * @UpdateUser:
 * @UpdateDate: 2018/9/28 18:24
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class FirstClientHandle extends ChannelInboundHandlerAdapter {

    /**
     * 此方法会在客户端连接成功后调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ":  客户端写出数据");

        //获取数据
        ByteBuf buf=getByteBuf(ctx);
        //写数据
        ctx.channel().writeAndFlush(buf);
    }

    /**
     * 此方法会在客户端收到消息后调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf= (ByteBuf) msg;
        System.out.println(new Date()+":  客户端收到信息 -> " +buf.toString(Charset.forName("utf-8")));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        //获取二进制抽象ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        //准备数据，指定字符串的字符集为utf-8
        byte[] bytes = "Gangan Hanson".getBytes(Charset.forName("utf-8"));
        //填充数据到ByteBuf
        return buffer.writeBytes(bytes);
    }
}
