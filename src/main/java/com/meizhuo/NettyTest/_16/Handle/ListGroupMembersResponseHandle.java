package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._16.Packet.ListGroupMembersResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 22:02
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 22:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ListGroupMembersResponseHandle extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket msg) throws Exception {
        String groupId = msg.getGroup();
        System.out.println("群聊[ "+groupId+" ]的成员有："+msg.getSessionList());
    }
}
