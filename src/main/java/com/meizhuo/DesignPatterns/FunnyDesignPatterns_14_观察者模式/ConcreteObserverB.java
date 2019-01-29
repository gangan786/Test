package com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/29 13:46
 * @UpdateUser:
 * @UpdateDate: 2019/1/29 13:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConcreteObserverB implements Observer {

    private String name;

    private String observerState;

    private ConcreteSubject subject;

    public ConcreteObserverB(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者类型B：" + name + " 新状态：" + observerState);
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}
