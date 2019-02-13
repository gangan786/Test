# 备忘录模式

备忘录模式：在不破坏封装性的前提下，捕获一个对象额内部状态，并在该对象之外保存这个状态。这样就可以将该对象恢复到原先保存的状态

+ 这是我见过最鸡肋的设计模式
+ 适用于需要保存的属性只是众多属性中的一小部分



这个是某个实现保存状态的类

~~~java
@ToString
public class Originator {

    private String state;

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
~~~

状态存档文件

~~~java
public class Memento {

    private String state;


    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
~~~

中间人（都不知道这个设计有什么存在的意义）

~~~java
public class Caretaker {

    @Setter
    @Getter
    private Memento memento;
}
~~~

客户端

~~~java
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
~~~

