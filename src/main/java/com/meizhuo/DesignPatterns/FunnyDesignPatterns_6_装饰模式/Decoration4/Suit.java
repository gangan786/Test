package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/6 21:53
 * @UpdateUser:
 * @UpdateDate: 2019/1/6 21:53
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Suit extends Finery {

    @Override
    public void show() {
        System.out.println("西装 ");
        super.show();
    }
}
