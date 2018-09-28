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
 * @CreateDate: 2018/9/28 18:46
 * @UpdateUser:
 * @UpdateDate: 2018/9/28 18:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class FirstServerHandle extends ChannelInboundHandlerAdapter {

    /**
     * 此方法在接受到客户端数据后回调
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
/*        //获取客户端发送的信息
        ByteBuf buf= (ByteBuf) msg;
        System.out.println(new Date()+":  服务端读到数据 -> "+buf.toString(Charset.forName("utf-8")) );*/

        ByteBuf buf = getByteBuf(ctx);
        ctx.channel().writeAndFlush(buf);

    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = "You are right".getBytes(Charset.forName("utf-8"));
        return buffer.writeBytes(bytes);
    }


}
