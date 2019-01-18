package com.meizhuo.DesignPatterns.FunnyDesignPatterns_11_12_外观模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_11_12_外观模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/18 23:10
 * @UpdateUser:
 * @UpdateDate: 2019/1/18 23:10
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        wayA();
        System.out.println("---------------------------------------------");
        wayB();
    }

    private static void wayB() {
        Fund fund = new Fund();
        fund.buyFund();
        fund.sellFund();
    }

    private static void wayA() {
        AssetsBehave stockA = new StockA();
        AssetsBehave stockB = new StockB();
        AssetsBehave nationalDebt = new NationalDebt();

        stockA.buy();
        stockB.buy();
        nationalDebt.buy();

        stockA.sell();
        stockB.sell();
        nationalDebt.sell();
    }

}
