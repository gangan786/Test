package com.meizhuo.DesignPatterns.FunnyDesignPatterns_13_建造者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_13_建造者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/24 13:17
 * @UpdateUser:
 * @UpdateDate: 2019/1/24 13:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        ConcreteBuilderA concreteBuilderA = new ConcreteBuilderA();
        ConcreteBuilderB concreteBuilderB = new ConcreteBuilderB();

        Director director = new Director();
        director.construct(concreteBuilderA);
        concreteBuilderA.getResult().show();

        director.construct(concreteBuilderB);
        concreteBuilderB.getResult().show();
    }

}
