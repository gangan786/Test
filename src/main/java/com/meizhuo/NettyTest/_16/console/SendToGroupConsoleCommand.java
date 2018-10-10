package com.meizhuo.NettyTest._16.console;

import com.meizhuo.NettyTest._16.Packet.GroupMessageRequstPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.console
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/10 11:15
 * @UpdateUser:
 * @UpdateDate: 2018/10/10 11:15
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入你要发送群组对应的groupId和信息(用空格隔开)");
        String groupId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new GroupMessageRequstPacket(groupId,message));
    }
}
