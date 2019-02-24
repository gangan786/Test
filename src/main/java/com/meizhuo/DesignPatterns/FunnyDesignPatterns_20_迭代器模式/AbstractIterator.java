package com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:迭代器抽象类
 * @Author: Gangan
 * @CreateDate: 2019/2/24 11:30
 * @UpdateUser:
 * @UpdateDate: 2019/2/24 11:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class AbstractIterator {
    /**
     * 定义得到开始对象
     *
     * @return
     */
    public abstract Object first();

    /**
     * 得到下一个对象
     *
     * @return
     */
    public abstract Object next();

    /**
     * 是否到结尾
     *
     * @return
     */
    public abstract boolean isDone();

    /**
     * 返回当前对象
     *
     * @return
     */
    public abstract Object currentItem();
}
