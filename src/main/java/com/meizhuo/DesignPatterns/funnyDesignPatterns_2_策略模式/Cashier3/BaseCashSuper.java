package com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/4 12:10
 * @UpdateUser:
 * @UpdateDate: 2019/1/4 12:10
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class BaseCashSuper {
    /**
     * 现金收取超类的抽象方法
     * @param money 原价
     * @return 当前价
     */
    public abstract double acceptCash(double money);
}
