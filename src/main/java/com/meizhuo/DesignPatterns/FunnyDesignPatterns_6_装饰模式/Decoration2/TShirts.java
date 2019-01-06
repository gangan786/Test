package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration2;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration2
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/5 15:12
 * @UpdateUser:
 * @UpdateDate: 2019/1/5 15:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class TShirts implements Finery {
    @Override
    public void show() {
        System.out.print("大T恤 ");
    }
}
