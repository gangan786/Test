package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._7.PacketCodeC;
import com.meizhuo.NettyTest._9.MessageRequestPacket;
import com.meizhuo.NettyTest._9.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._11
 * @ClassName: ${TYPE_NAME}
 * @Description: 完成消息处理逻辑
 * @Author: Gangan
 * @CreateDate: 2018/10/1 11:27
 * @UpdateUser:
 * @UpdateDate: 2018/10/1 11:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class MessageRequestHandle extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        //处理消息
        System.out.println(new Date() + " :收到客户端信息:  " + msg.getMessage());
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setMessage("服务端回复【" + msg.getMessage() + "】");

        ctx.channel().writeAndFlush(responsePacket);
    }
}
