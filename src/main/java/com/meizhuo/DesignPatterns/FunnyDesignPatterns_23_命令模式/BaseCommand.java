package com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/27 9:48
 * @UpdateUser:
 * @UpdateDate: 2019/2/27 9:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class BaseCommand {

    protected Barbecuer receive;

    public BaseCommand(Barbecuer receive) {
        this.receive = receive;
    }

    /**
     * 执行指令
     */
    public abstract void executeCommand();

}
