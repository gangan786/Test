package com.meizhuo.NettyTest._16.console;

import com.meizhuo.NettyTest._16.Packet.ListGroupMembersRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.console
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:40
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:40
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ListGroupMembersConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("输入对应groupId，获取成员列表");
        String groupId = scanner.next();

        ListGroupMembersRequestPacket requestPacket = new ListGroupMembersRequestPacket();
        requestPacket.setGroupId(groupId);
        channel.writeAndFlush(requestPacket);
    }
}
