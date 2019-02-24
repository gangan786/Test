package com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/24 12:01
 * @UpdateUser:
 * @UpdateDate: 2019/2/24 12:01
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();

        concreteAggregate.setItem(0, "热夜");
        concreteAggregate.setItem(1, "冻朝");
        concreteAggregate.setItem(2, "行李");
        concreteAggregate.setItem(3, "老外");
        concreteAggregate.setItem(4, "内部员工");
        concreteAggregate.setItem(5,"小偷");

        AbstractIterator iterator = concreteAggregate.createIterator();

        Object first = iterator.first();

        while (!iterator.isDone()) {
            System.out.println(iterator.currentItem() + " 请买票");
            iterator.next();
        }


    }
}
