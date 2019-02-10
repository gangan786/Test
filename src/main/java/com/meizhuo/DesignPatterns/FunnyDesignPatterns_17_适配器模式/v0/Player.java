package com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/10 10:35
 * @UpdateUser:
 * @UpdateDate: 2019/2/10 10:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class Player {

    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void Attack();

    public abstract void Defense();
}
