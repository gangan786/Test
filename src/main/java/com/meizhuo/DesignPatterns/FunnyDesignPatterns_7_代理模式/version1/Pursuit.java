package com.meizhuo.DesignPatterns.FunnyDesignPatterns_7_代理模式.version1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_7_代理模式.version1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/7 16:52
 * @UpdateUser:
 * @UpdateDate: 2019/1/7 16:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Pursuit implements GiveGift {

    private SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveDolls() {
        System.out.println(schoolGirl.getName() + " 送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(schoolGirl.getName() + " 送你花花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(schoolGirl.getName() + " 送你巧克力");
    }
}
