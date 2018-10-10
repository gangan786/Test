package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._16.Packet.GroupMessageRequstPacket;
import com.meizhuo.NettyTest._16.Packet.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/10 10:21
 * @UpdateUser:
 * @UpdateDate: 2018/10/10 10:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class GroupMessageRequestHandle extends SimpleChannelInboundHandler<GroupMessageRequstPacket> {

    public static final GroupMessageRequestHandle INSTANCE=new GroupMessageRequestHandle();

    private GroupMessageRequestHandle(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequstPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();
        responsePacket.setFromGroupId(groupId);
        responsePacket.setFromUser(SessionUtil.getSession(ctx.channel()));
        responsePacket.setMessage(msg.getMessage());

        //拿到群聊对应的ChannelGroup，写到每个客户端
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.writeAndFlush(responsePacket);
    }
}
