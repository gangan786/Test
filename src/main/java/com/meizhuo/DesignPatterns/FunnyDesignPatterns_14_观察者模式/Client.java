package com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/29 14:05
 * @UpdateUser:
 * @UpdateDate: 2019/1/29 14:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        //注册订阅者
        concreteSubject.attach(new ConcreteObserverA("冬冬", concreteSubject));
        concreteSubject.attach(new ConcreteObserverB("Gangan",concreteSubject));

        //状态发生改变，被观察者执行观察者的update方法
        concreteSubject.setSubjectState("Test");
        concreteSubject.notifyObserver();
    }

}
