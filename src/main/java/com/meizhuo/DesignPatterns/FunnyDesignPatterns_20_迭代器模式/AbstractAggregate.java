package com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/24 11:38
 * @UpdateUser:
 * @UpdateDate: 2019/2/24 11:38
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class AbstractAggregate {

    /**
     * 创建迭代器
     * @return
     */
    public abstract AbstractIterator createIterator();

}
