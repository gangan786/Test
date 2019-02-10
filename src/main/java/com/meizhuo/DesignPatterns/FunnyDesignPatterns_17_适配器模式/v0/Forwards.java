package com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/10 10:37
 * @UpdateUser:
 * @UpdateDate: 2019/2/10 10:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("前锋 " + name + " 进攻");
    }

    @Override
    public void Defense() {
        System.out.println("前锋 " + name + " 防守");
    }
}
