package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._11.LoginRequestHandle;
import com.meizhuo.NettyTest._11.MessageRequestHandle;
import com.meizhuo.NettyTest._7.Packet;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;
import static com.meizhuo.NettyTest._7.Command.*;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/10 12:43
 * @UpdateUser:
 * @UpdateDate: 2018/10/10 12:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class AIMHandle extends SimpleChannelInboundHandler<Packet> {

    public static final AIMHandle INSTANCE = new AIMHandle();

    private Map<Byte,SimpleChannelInboundHandler<? extends Packet>> handlerMap;

    private AIMHandle() {
        handlerMap = new HashMap<>();

        handlerMap.put(LOGIN_REQUEST, LoginRequestHandle.INSTANCE);
        handlerMap.put(MESSAGE_REQUEST, MessageRequestHandle.INSTANCE);
        handlerMap.put(CREATE_GROUP_REQUEST, CreateGroupRequestHandle.INSTANCE);
        handlerMap.put(JOIN_GROUP_REQUEST, JoinGroupRequestHandle.INSTANCE);
        handlerMap.put(QUIT_GROUP_REQUEST, QuitGroupRequestHandle.INSTANCE);
        handlerMap.put(LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestHandle.INSTANCE);
        handlerMap.put(GROUP_MESSAGE_REQUEST, GroupMessageRequestHandle.INSTANCE);
        handlerMap.put(LOGOUT_REQUEST, LogoutRequestHandle.INSTANCE);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {
        handlerMap.get(msg.getCommand()).channelRead(ctx, msg);
    }
}
