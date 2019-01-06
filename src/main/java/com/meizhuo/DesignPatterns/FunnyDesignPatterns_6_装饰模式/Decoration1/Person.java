package com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_6_装饰模式.Decoration1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/5 14:46
 * @UpdateUser:
 * @UpdateDate: 2019/1/5 14:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void wearTShirts() {
        System.out.print("大T恤 ");
    }

    public void wearBigTrouser() {
        System.out.print("垮裤 ");
    }

    public void wearSneakers() {
        System.out.print("破球鞋 ");
    }

    public void wearSuit() {
        System.out.print("西装");
    }

    public void wearTile() {
        System.out.print("领带 ");
    }

    public void wearLeatherShoes() {
        System.out.print("皮鞋 ");
    }

    public void show() {
        System.out.println("装扮的 " + name);
    }

}
