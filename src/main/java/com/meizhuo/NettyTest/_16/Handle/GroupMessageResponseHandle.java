package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._15.Session;
import com.meizhuo.NettyTest._16.Packet.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/10 11:12
 * @UpdateUser:
 * @UpdateDate: 2018/10/10 11:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class GroupMessageResponseHandle extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket responsePacket) throws Exception {
        String fromGroupId = responsePacket.getFromGroupId();
        Session fromUser = responsePacket.getFromUser();
        System.out.println("收到群[" + fromGroupId + "]中[" + fromUser + "]发来的消息：" + responsePacket.getMessage());
    }
}
