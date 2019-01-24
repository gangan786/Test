package com.meizhuo.DesignPatterns.FunnyDesignPatterns_13_建造者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_13_建造者模式
 * @ClassName: ${TYPE_NAME}
 * @Description: 抽象所有Product的共性操作
 * @Author: Gangan
 * @CreateDate: 2019/1/24 13:09
 * @UpdateUser:
 * @UpdateDate: 2019/1/24 13:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class Builder {

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getResult();

}
