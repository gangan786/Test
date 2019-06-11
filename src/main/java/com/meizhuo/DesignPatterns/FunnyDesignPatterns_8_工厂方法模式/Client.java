package com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_??????????
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/8 21:08
 * @UpdateUser:
 * @UpdateDate: 2019/1/8 21:08
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        IFactory factory = new UndergraduateFactory();
        LeiFeng stuA = factory.createLeiFeng("????");
        stuA.buySomething();
        stuA.sweepSomething();
        stuA.washSomething();

        factory = new VolunteerFactory();
        LeiFeng stuB = factory.createLeiFeng("????");
        stuB.buySomething();
        stuB.sweepSomething();
        stuB.washSomething();

    }

}
