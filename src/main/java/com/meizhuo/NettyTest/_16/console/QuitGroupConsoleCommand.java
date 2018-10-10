package com.meizhuo.NettyTest._16.console;

import com.meizhuo.NettyTest._16.Packet.QuitGroupRequestPacket;
import com.meizhuo.NettyTest._7.Command;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.console
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:34
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class QuitGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket requestPacket = new QuitGroupRequestPacket();
        System.out.println("输入对应groupId，退出群聊");
        String groupId = scanner.next();
        requestPacket.setGroupId(groupId);
        channel.writeAndFlush(requestPacket);
    }
}
