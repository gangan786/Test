package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._11.LoginResponseHandle;
import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._16.Packet.LogoutResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/6 16:51
 * @UpdateUser:
 * @UpdateDate: 2018/10/6 16:51
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class LogoutResponseHandle extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    public static final LogoutResponseHandle INSTANCE=new LogoutResponseHandle();

    private LogoutResponseHandle(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}
