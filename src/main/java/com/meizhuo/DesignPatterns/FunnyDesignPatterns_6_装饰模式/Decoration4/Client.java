package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/6 21:55
 * @UpdateUser:
 * @UpdateDate: 2019/1/6 21:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        Person gangan = new Person("Gangan");
        System.out.println("第一种装扮：");
        Sneakers sneakers = new Sneakers();
        BigTrouser bigTrouser = new BigTrouser();
        TShirts tShirts = new TShirts();

        //开始装饰
        sneakers.decorate(gangan);
        bigTrouser.decorate(sneakers);
        tShirts.decorate(bigTrouser);
        tShirts.show();

        System.out.println("第二种装饰：");
        LeatherShoes leatherShoes = new LeatherShoes();
        Tie tie = new Tie();
        Suit suit = new Suit();
        leatherShoes.decorate(gangan);
        tie.decorate(leatherShoes);
        suit.decorate(tie);
        suit.show();
    }

}
