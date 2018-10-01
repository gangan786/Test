package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._9.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._11
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/1 12:17
 * @UpdateUser:
 * @UpdateDate: 2018/10/1 12:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class MessageResponHandle extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        System.out.println(new Date() + ":  收到服务端的信息:  " + msg.getMessage());
    }
}
