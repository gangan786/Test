package com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式;

import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/8 20:48
 * @UpdateUser:
 * @UpdateDate: 2019/1/8 20:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Undergraduate extends LeiFeng {

    public Undergraduate(String name) {
        setIdentity("大学生");
        setName(name);
    }

    @Override
    public void sweepSomething() {
        System.out.println(getIdentity() + getName() + " 扫室内");
    }

    @Override
    public void washSomething() {
        System.out.println(getIdentity() + getName() + " 洗衣服");
    }

    @Override
    public void buySomething() {
        System.out.println(getIdentity() + getName() + " 卖大米");
    }
}
