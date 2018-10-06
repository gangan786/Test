package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._16.Packet.CreateGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/6 16:07
 * @UpdateUser:
 * @UpdateDate: 2018/10/6 16:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class CreateGroupResponseHandle extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket msg) throws Exception {
        if (msg.isSuccess()){
            System.out.println("群聊创建成功，id为[ "+msg.getGroupId()+" ]");
            System.out.println("群成员有："+msg.getUserNameList());
        }
    }
}
