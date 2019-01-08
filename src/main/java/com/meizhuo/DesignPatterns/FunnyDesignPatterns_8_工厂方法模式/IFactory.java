package com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_8_工厂方法模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/8 21:01
 * @UpdateUser:
 * @UpdateDate: 2019/1/8 21:01
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface IFactory {
    /**
     * 所有工厂实现类的统一接口
     *
     * @param name
     * @return
     */
    LeiFeng createLeiFeng(String name);
}
