package com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/13 12:25
 * @UpdateUser:
 * @UpdateDate: 2019/1/13 12:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass classA = new ConcreteClassA();
        classA.diffOperation1();
        classA.diffOperation2();
        System.out.println("--------------------------------");
        ConcreteClassB classB = new ConcreteClassB();
        classB.diffOperation1();
        classB.diffOperation2();
    }
}
