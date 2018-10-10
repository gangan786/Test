package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._15.Session;
import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._16.Packet.ListGroupMembersRequestPacket;
import com.meizhuo.NettyTest._16.Packet.ListGroupMembersResponsePacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:50
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandle extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final ListGroupMembersRequestHandle INSTANCE=new ListGroupMembersRequestHandle();

    private ListGroupMembersRequestHandle(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup group = SessionUtil.getChannelGroup(groupId);

        ArrayList<Session> sessions = new ArrayList<>();
        for (Channel channel : group) {
            Session session = SessionUtil.getSession(channel);
            sessions.add(session);
        }

        //构建应答返回客户端
        ListGroupMembersResponsePacket responsePacket = new ListGroupMembersResponsePacket();
        responsePacket.setGroup(groupId);
        responsePacket.setSessionList(sessions);
        ctx.channel().writeAndFlush(responsePacket);
    }
}
