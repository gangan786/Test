package com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式;

import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/8 20:44
 * @UpdateUser:
 * @UpdateDate: 2019/1/8 20:44
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
@Data
public abstract class LeiFeng {

    private String name;

    private String identity;

    /**
     * 扫
     */
    public abstract void sweepSomething();

    /**
     * 洗
     */
    public abstract void washSomething();

    /**
     * 买
     */
    public abstract void buySomething();

}
