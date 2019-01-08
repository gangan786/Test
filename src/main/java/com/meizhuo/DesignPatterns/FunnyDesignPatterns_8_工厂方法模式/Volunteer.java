package com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/8 20:57
 * @UpdateUser:
 * @UpdateDate: 2019/1/8 20:57
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Volunteer extends LeiFeng {

    public Volunteer(String name) {
        setIdentity("志愿者");
        setName(name);
    }

    @Override
    public void sweepSomething() {
        System.out.println(getIdentity() + getName() + " 扫室外");
    }

    @Override
    public void washSomething() {
        System.out.println(getIdentity() + getName() + " 洗厨房");
    }

    @Override
    public void buySomething() {
        System.out.println(getIdentity() + getName() + " 买油盐");
    }
}
