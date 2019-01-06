package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration2;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration2
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/5 15:23
 * @UpdateUser:
 * @UpdateDate: 2019/1/5 15:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        Person gangan = new Person("Gangan");
        System.out.println("第一种装扮：");
        Finery tShirts = new TShirts();
        Finery bigTourse = new BigTourse();
        Finery sneakers = new Sneakers();
        tShirts.show();
        bigTourse.show();
        sneakers.show();
        gangan.show();

        System.out.println("第二种装扮：");
        Finery suit = new Suit();
        Finery tile = new Tile();
        Finery leatherShoes = new LeatherShoes();

        suit.show();
        tile.show();
        leatherShoes.show();
        gangan.show();
    }
}
