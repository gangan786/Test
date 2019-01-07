package com.meizhuo.DesignPatterns.FunnyDesignPatterns_7_代理模式.version1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_7_代理模式.version1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/7 17:05
 * @UpdateUser:
 * @UpdateDate: 2019/1/7 17:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("刘冬冬");

        GiveGift Gangan = new Proxy(schoolGirl);

        Gangan.giveChocolate();
        Gangan.giveDolls();
        Gangan.giveFlowers();

    }

}
