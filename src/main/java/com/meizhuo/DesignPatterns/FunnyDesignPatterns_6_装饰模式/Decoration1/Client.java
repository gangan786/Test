package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/5 14:52
 * @UpdateUser:
 * @UpdateDate: 2019/1/5 14:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        Person gangan = new Person("Gangan");
        System.out.println("第一种装扮：");
        gangan.wearTShirts();
        gangan.wearBigTrouser();
        gangan.show();

        System.out.println("第二种装扮：");
        gangan.wearSuit();
        gangan.wearTile();
        gangan.wearLeatherShoes();
        gangan.show();
    }
}
