package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._15.Session;
import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._9.MessageRequestPacket;
import com.meizhuo.NettyTest._9.MessageResponsePacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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
        //获取消息发送方的会话消息
        Session session = SessionUtil.getSession(ctx.channel());

        //构建应答
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setFromUserId(session.getUserId());
        responsePacket.setFromUserName(session.getUserName());
        responsePacket.setMessage(msg.getMessage());

        //拿到消息接受放的channel
        Channel toChannel = SessionUtil.getChannel(msg.getToUserId());

        //将消息发送给接受方
        if (toChannel != null && SessionUtil.hasLogin(toChannel)) {
            //以下代码的顺序是有讲究的
            responsePacket.setStateDes("发送成功");
            //这个回写的状态码是0
            ctx.channel().writeAndFlush(responsePacket);
            responsePacket.setCode(200);
            //这个回写的状态码是200
            toChannel.writeAndFlush(responsePacket);
        } else {
            responsePacket.setCode(400);
            responsePacket.setStateDes("[ " +
                    msg.getToUserId() +
                    " ] 该用户不存在或不在线" +
                    "信息发送失败");
            ctx.channel().writeAndFlush(responsePacket);
        }

    }
}
