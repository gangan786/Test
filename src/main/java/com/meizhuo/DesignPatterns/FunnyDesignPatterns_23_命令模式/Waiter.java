package com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/27 13:22
 * @UpdateUser:
 * @UpdateDate: 2019/2/27 13:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Waiter {

    private List<BaseCommand> commands = new ArrayList<>();

    public void setCommand(BaseCommand command) {
        //这里可对命令进行校验，检查是否还有库存
        commands.add(command);
        System.out.println("增加订单：" + command.toString() + " 时间：" + new Date().getTime());
    }

    public void cannelCommand(BaseCommand command) {
        commands.remove(command);
    }

    public void actionBake() {
        for (BaseCommand command : commands) {
            command.executeCommand();
        }
    }
}
