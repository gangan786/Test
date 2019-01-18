package com.meizhuo.DesignPatterns.FunnyDesignPatterns_11_12_外观模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_11_12_外观模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/18 23:00
 * @UpdateUser:
 * @UpdateDate: 2019/1/18 23:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Fund {

    private AssetsBehave stockA;

    private AssetsBehave stockB;

    private AssetsBehave nationalDebt;

    public Fund() {
        stockA = new StockA();
        stockB = new StockB();
        nationalDebt = new NationalDebt();
    }

    public void buyFund(){
        stockA.buy();
        stockB.buy();
        nationalDebt.buy();
    }

    public void sellFund(){
        stockA.sell();
        stockB.sell();
        nationalDebt.sell();
    }


}
