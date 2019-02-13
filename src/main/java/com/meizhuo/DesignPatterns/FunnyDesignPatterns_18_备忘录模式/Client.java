package com.meizhuo.DesignPatterns.FunnyDesignPatterns_18_备忘录模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_18_备忘录模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/13 21:40
 * @UpdateUser:
 * @UpdateDate: 2019/2/13 21:40
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("状态A");

        System.out.println(originator.toString());

        //状态保存的中间值
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        //改变状态
        originator.setState("状态B");
        System.out.println(originator.toString());

        //恢复状态
        originator.setMemento(caretaker.getMemento());
        System.out.println(originator.toString());
    }

}
