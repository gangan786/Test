# 观察者模式

这里描述一下观察者模式所要达到的一个效果：当被观察者的状态发生改变时，观察者能对这个反应做出改变，通俗一点就是：当老板回来的时候（被观察者），所有员工必须停止无关活动专心工作

被观察者的抽象

~~~java
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
~~~

观察者的抽象

~~~java
public interface Observer {
    /**
     * 对状态改变做出的反应
     */
    void update();
}
~~~

具体的观察者

~~~java
public class ConcreteObserverA implements Observer {

    private String name;

    private String observerState;

    private ConcreteSubject subject;

    public ConcreteObserverA(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者类型A：" + name + " 新状态：" + observerState);
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}

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
~~~

具体的被观察者

```java
public class ConcreteSubject extends Subject {

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
```

客户端调用

~~~java
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
~~~

## 总结

+ 观察者模式又叫发布——订阅模式。定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化的时，会通知所有观察者对象，使他们能够自动更新自己
+ 动机：将一个系统分割成一系类相互协作的类有一个很不好的副作用，那就是需要维护相关对象的一致性。我们不希望为了维持一致性而导致各类精密耦合，这样会给维护，拓展和重用都带来不便
+ 时机：当一个对象的改变需要同时改变其他对象，而且它不知道具体由多少个对象有待改变时，应该考虑使用观察者模式，当一个抽象模式有两个方面，其中一方面依赖另一方面，这时用观察者模式可以将这两者封装在独立的对象中使他们各自独立的改变和复用
+ 不足：观察者模式中的观察者需要统一实现某个固定接口以供被观察者调用（例如上述的update方法），但是有时被观察者状态发生改变，调用观察者的方法签名都是不经相同的，例如点击运行按钮，有的窗口要显示，有的窗口要隐藏，显然执行的方法不同，而且方法不可修改添加，这时候要想实现观察者的效果的话，C#可以使用委托，Java可以使用反射，具体可查看这篇[博客](https://blog.csdn.net/nvd11/article/details/42367109)

