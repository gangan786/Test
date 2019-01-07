package com.meizhuo.DesignPatterns.FunnyDesignPatterns_7_代理模式.version1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_7_代理模式.version1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/7 17:01
 * @UpdateUser:
 * @UpdateDate: 2019/1/7 17:01
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Proxy implements GiveGift {

    private Pursuit pursuit;

    public Proxy(SchoolGirl schoolGirl) {
        pursuit = new Pursuit(schoolGirl);
    }

    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
