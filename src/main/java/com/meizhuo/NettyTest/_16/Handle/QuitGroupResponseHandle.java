package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._16.Packet.QuitGroupResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:30
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class QuitGroupResponseHandle extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {

    public static final QuitGroupResponseHandle INSTANCE=new QuitGroupResponseHandle();

    private QuitGroupResponseHandle(){

    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket msg) throws Exception {
        System.out.println(msg.getReason());
    }
}
