package com.meizhuo.NettyTest._19;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._19
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/11 14:29
 * @UpdateUser:
 * @UpdateDate: 2018/10/11 14:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class HeartBeatRequestHandle extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

    public static final HeartBeatRequestHandle INSTANCE = new HeartBeatRequestHandle();

    private HeartBeatRequestHandle() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatRequestPacket msg) throws Exception {
        ctx.writeAndFlush(new HeartBeatResponsePacket());
    }
}
