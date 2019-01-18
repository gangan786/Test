package com.meizhuo.DesignPatterns.FunnyDesignPatterns_11_12_外观模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_11_12_外观模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/18 22:58
 * @UpdateUser:
 * @UpdateDate: 2019/1/18 22:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class NationalDebt implements AssetsBehave {
    @Override
    public void sell() {
        System.out.println("国债卖出");
    }

    @Override
    public void buy() {
        System.out.println("国债买入");
    }
}
