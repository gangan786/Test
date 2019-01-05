package com.meizhuo.DesignPatterns.FunnyDesignPatterns_2_策略模式.Cashier3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/4 12:19
 * @UpdateUser:
 * @UpdateDate: 2019/1/4 12:19
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class CashReturn extends BaseCashSuper {

    private double moneyCondition;
    private double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money > moneyCondition) {
            result = money - (int) (money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
