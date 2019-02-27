package com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_23_命令模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/27 13:30
 * @UpdateUser:
 * @UpdateDate: 2019/2/27 13:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        //开店准备
        Barbecuer barbecuer = new Barbecuer();
        BakeChickenWingCommand bakeChickenWingCommand = new BakeChickenWingCommand(barbecuer);
        BakeMuttonCommand bakeMuttonCommand = new BakeMuttonCommand(barbecuer);
        Waiter waiter = new Waiter();

        //开始营业
        //服务员开始下单
        waiter.setCommand(bakeMuttonCommand);
        waiter.setCommand(bakeChickenWingCommand);

        //下单完成一次性通知后厨
        waiter.actionBake();
    }

}
