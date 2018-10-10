package com.meizhuo.NettyTest._16.Handle;

import com.meizhuo.NettyTest._15.Session;
import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._16.Packet.CreateGroupRequestPacket;
import com.meizhuo.NettyTest._16.Packet.CreateGroupResponsePacket;
import com.meizhuo.NettyTest._16.Util.IDUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Handle
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/6 15:33
 * @UpdateUser:
 * @UpdateDate: 2018/10/6 15:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class CreateGroupRequestHandle extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    public static final CreateGroupRequestHandle INSTANCE = new CreateGroupRequestHandle();

    private CreateGroupRequestHandle() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
        List<String> userIdList = msg.getUserIdList();

        ArrayList<String> userNameList = new ArrayList<>();

        //创建一个channel分组
        DefaultChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());

        //筛选出待加入群聊用户的channel和userName
        for (String userId : userIdList) {
            Channel userChannel = SessionUtil.getChannel(userId);
            if (userChannel != null) {
                channelGroup.add(userChannel);
                userNameList.add(SessionUtil.getSession(userChannel).getUserName());
            }
        }

        //创建群聊创建响应
        String groupId = IDUtil.randomId();
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(groupId);
        createGroupResponsePacket.setUserNameList(userNameList);

        //给每个客户端发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.println("群创建成功，id为[ " + groupId + " ]");
        System.out.println("群里面有：" + createGroupResponsePacket.getUserNameList());

        //保存群组相关信息
        SessionUtil.bindChannelGroup(groupId, channelGroup);
    }
}
