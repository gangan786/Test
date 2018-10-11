package com.meizhuo.NettyTest._19;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._19
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/11 13:45
 * @UpdateUser:
 * @UpdateDate: 2018/10/11 13:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class IMIdleStateHandle extends IdleStateHandler {

    private static final int READ_IDLE_TIME = 15;

    public IMIdleStateHandle() {
        //这里的参数表示如果15秒没有读到数据就视为假死
        super(READ_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    /**
     * 连接假死后会调用这个方法
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println(READ_IDLE_TIME+"秒未读到数据，关闭连接");
        ctx.channel().close();
    }
}
