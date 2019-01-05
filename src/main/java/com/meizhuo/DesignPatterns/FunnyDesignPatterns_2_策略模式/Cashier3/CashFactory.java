package com.meizhuo.DesignPatterns.FunnyDesignPatterns_2_策略模式.Cashier3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/4 12:26
 * @UpdateUser:
 * @UpdateDate: 2019/1/4 12:26
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class CashFactory {

    public static BaseCashSuper createCashAccept(String type) {
        BaseCashSuper baseCashSuper = null;
        switch (type) {
            case "1.正常收费":
                baseCashSuper = new CashNormal();
                break;
            case "2.满300返100":
                baseCashSuper = new CashReturn(300, 100);
                break;
            case "3.打八折":
                baseCashSuper = new CashRebate("8");
                break;
            default:
                break;
        }
        return baseCashSuper;
    }

}
