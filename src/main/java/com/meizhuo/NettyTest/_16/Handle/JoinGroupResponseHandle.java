package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._16.Packet.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:04
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class JoinGroupResponseHandle extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

    public static final JoinGroupResponseHandle INSTANCE=new JoinGroupResponseHandle();

    private JoinGroupResponseHandle(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket msg) throws Exception {
            System.out.println("加入群聊[ "+msg.getGroupId()+" ] "+msg.getReason());
    }
}
