package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration2;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration2
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/5 15:16
 * @UpdateUser:
 * @UpdateDate: 2019/1/5 15:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Suit implements Finery {
    @Override
    public void show() {
        System.out.print("西装 ");
    }
}
