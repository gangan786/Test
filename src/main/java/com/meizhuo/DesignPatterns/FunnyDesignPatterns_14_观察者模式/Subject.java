package com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_14_观察者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/29 13:32
 * @UpdateUser:
 * @UpdateDate: 2019/1/29 13:32
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    /**
     * 添加观察者，保存通知对象
     *
     * @param observer 观察者
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 执行所有观察者的update方法
     */
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
