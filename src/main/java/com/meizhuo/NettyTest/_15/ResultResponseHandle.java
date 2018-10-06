package com.meizhuo.NettyTest._15;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._15
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/6 12:02
 * @UpdateUser:
 * @UpdateDate: 2018/10/6 12:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ResultResponseHandle extends SimpleChannelInboundHandler<ResponsePacket> {

    private static final int MESSAGE_SUCCESS_CODE = 200;

    private static final int MESSAGE_FAIL_CODE = 400;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponsePacket msg) throws Exception {
        if (msg.getCode() == MESSAGE_SUCCESS_CODE) {
            System.out.println(msg.getStateDes());
        } else if (msg.getCode() == MESSAGE_FAIL_CODE) {
            System.out.println(msg.getStateDes());
        }
    }
}
