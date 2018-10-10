package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._9.MessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._11
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/1 12:17
 * @UpdateUser:
 * @UpdateDate: 2018/10/1 12:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class MessageResponHandle extends SimpleChannelInboundHandler<MessageResponsePacket> {

    public static final MessageResponHandle INSTANCE = new MessageResponHandle();

    private MessageResponHandle() {

    }

    private static final int MESSAGE_SUCCESS_CODE = 200;

    private static final int MESSAGE_FAIL_CODE = 400;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        if (msg.getCode() == MESSAGE_SUCCESS_CODE) {
            String fromUserId = msg.getFromUserId();
            String fromUserName = msg.getFromUserName();
            System.out.println(fromUserId + ":" + fromUserName + " -> " + msg
                    .getMessage());
        } else if (msg.getCode() == MESSAGE_FAIL_CODE) {
            System.out.println(msg.getStateDes());
        }

    }
}
