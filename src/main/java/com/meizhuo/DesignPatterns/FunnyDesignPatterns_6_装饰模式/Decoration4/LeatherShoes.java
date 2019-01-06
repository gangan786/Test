package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/6 21:52
 * @UpdateUser:
 * @UpdateDate: 2019/1/6 21:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class LeatherShoes extends Finery {

    @Override
    public void show() {
        System.out.println("皮鞋 ");
        super.show();
    }
}
