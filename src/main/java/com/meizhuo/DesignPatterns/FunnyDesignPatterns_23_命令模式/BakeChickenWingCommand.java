package com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/27 13:21
 * @UpdateUser:
 * @UpdateDate: 2019/2/27 13:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class BakeChickenWingCommand extends BaseCommand {

    public BakeChickenWingCommand(Barbecuer receive) {
        super(receive);
    }

    @Override
    public void executeCommand() {
        receive.bakeChickenWing();
    }

    @Override
    public String toString() {
        return "烤鸡翅订单";
    }
}
