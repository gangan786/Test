package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/5 17:02
 * @UpdateUser:
 * @UpdateDate: 2019/1/5 17:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConcreteDecoratorA extends Decorator {
    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedState = "NEW STATE";
        System.out.println("具体装饰对象A的操作");
    }
}
