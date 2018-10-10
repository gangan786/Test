package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._16.Packet.JoinGroupRequestPacket;
import com.meizhuo.NettyTest._16.Packet.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 20:30
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 20:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class JoinGroupRequestHandle extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket msg) throws Exception {
        //获取对应的channelGroup，然后将当前用户的channel添加进去
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        //构建响应回应客户端
        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();

        if (channelGroup != null) {
            channelGroup.add(ctx.channel());
            responsePacket.setCode(200);
            responsePacket.setGroupId(groupId);
            responsePacket.setSuccess(true);
            responsePacket.setReason("加入成功");
        } else {
            responsePacket.setCode(400);
            responsePacket.setGroupId(groupId);
            responsePacket.setSuccess(false);
            responsePacket.setReason("该群聊不存在或者群聊id错误");
        }
        ctx.channel().writeAndFlush(responsePacket);


    }
}
