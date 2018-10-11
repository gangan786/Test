package com.meizhuo.NettyTest._19;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._19
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/11 14:02
 * @UpdateUser:
 * @UpdateDate: 2018/10/11 14:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class HeartBeatTimeHandle extends ChannelInboundHandlerAdapter {

    private static final int HEARTBEAT_INTERVAL = 5;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.executor().scheduleAtFixedRate((Runnable) () -> {
            ctx.writeAndFlush(new HeartBeatRequestPacket());
        }, HEARTBEAT_INTERVAL, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
        super.channelActive(ctx);
    }
}
