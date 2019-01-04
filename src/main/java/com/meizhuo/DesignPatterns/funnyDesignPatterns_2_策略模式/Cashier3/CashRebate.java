package com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/4 12:15
 * @UpdateUser:
 * @UpdateDate: 2019/1/4 12:15
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class CashRebate extends BaseCashSuper {

    private double moneyRebate = 0;

    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.valueOf(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money * (moneyRebate * 0.1);
    }
}
