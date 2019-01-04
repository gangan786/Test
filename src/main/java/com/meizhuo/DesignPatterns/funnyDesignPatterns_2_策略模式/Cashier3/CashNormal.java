package com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/4 12:14
 * @UpdateUser:
 * @UpdateDate: 2019/1/4 12:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class CashNormal extends BaseCashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
