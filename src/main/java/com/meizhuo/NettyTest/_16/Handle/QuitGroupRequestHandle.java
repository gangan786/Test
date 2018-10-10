package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._16.Packet.QuitGroupRequestPacket;
import com.meizhuo.NettyTest._16.Packet.QuitGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:17
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class QuitGroupRequestHandle extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
        if (channelGroup != null && channelGroup.remove(ctx.channel())) {
            responsePacket.setCode(200);
            responsePacket.setGroupId(groupId);
            responsePacket.setSuccess(true);
            responsePacket.setReason("退出[ " + groupId + " ]群聊成功");
        } else {
            responsePacket.setCode(400);
            responsePacket.setGroupId(groupId);
            responsePacket.setSuccess(false);
            responsePacket.setReason("退出[ " + groupId + " ]群聊失败，群聊不存在或者id错误");
        }
        ctx.channel().writeAndFlush(responsePacket);
    }
}
