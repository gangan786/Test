package com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/29 13:31
 * @UpdateUser:
 * @UpdateDate: 2019/1/29 13:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface Observer {
    /**
     * 对状态改变做出的反应
     */
    void update();
}
