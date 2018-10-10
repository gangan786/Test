package com.meizhuo.NettyTest._16.console;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/6 14:29
 * @UpdateUser:
 * @UpdateDate: 2018/10/6 14:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ConsloeCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsloeCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("sendToUser", new SendToUserConsloeCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
        consoleCommandMap.put("joinGroup",new JoinGroupConsoleCommand());
        consoleCommandMap.put("quitGroup",new QuitGroupConsoleCommand());
        consoleCommandMap.put("listGroup",new ListGroupMembersConsoleCommand());
        consoleCommandMap.put("sendToGroup",new SendToGroupConsoleCommand());

    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入指令");
        String command = scanner.next();
        ConsoleCommand consoleCommand = consoleCommandMap.get(command);
        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
        }else {
            System.out.println("无法识别【 "+command+" 】指令，请重新输入");
        }
    }
}
