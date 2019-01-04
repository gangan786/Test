package com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier4;

import com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3.BaseCashSuper;
import com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3.CashNormal;
import com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3.CashRebate;
import com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier3.CashReturn;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/4 14:59
 * @UpdateUser:
 * @UpdateDate: 2019/1/4 14:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class CashContext {

    private BaseCashSuper baseCashSuper = null;


    public CashContext(String way) {
        switch (way) {
            case "1.正常收费":
                baseCashSuper = new CashNormal();
                break;
            case "2.满300返100":
                baseCashSuper = new CashReturn(300, 100);
                break;
            case "3.打八折":
                baseCashSuper = new CashRebate("8");
            default:
                break;
        }
    }

    public double getResult(double money) {
        return baseCashSuper.acceptCash(money);
    }

}
