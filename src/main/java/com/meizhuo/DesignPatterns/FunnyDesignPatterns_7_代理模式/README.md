# 代理模式

为别人做嫁衣

这里描述一个场景（纯属虚构）：有个人甲（名字不重要）喜欢乙，甲怂的要死，委托丙经常送东西给乙，所以这里丙成了代理对象，但是最终丙跟乙最终在一起了。

这个代表乙

~~~java
@Getter
@Setter
public class SchoolGirl {

    private String name;

}
~~~

代理对象和被代理必然有相同的操作接口，所以以下定义的是接口

~~~java
public interface GiveGift {

    /**
     * 送娃娃
     */
    void giveDolls();

    /**
     * 送花
     */
    void giveFlowers();

    /**
     * 送巧克力
     */
    void giveChocolate();

}
~~~

以下是实现同一GiveGift接口的两个类

被代理类（也就是真正具体逻辑的实现类）

~~~java
public class Pursuit implements GiveGift {

    private SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveDolls() {
        System.out.println(schoolGirl.getName() + " 送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(schoolGirl.getName() + " 送你花花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(schoolGirl.getName() + " 送你巧克力");
    }
}
~~~

代理类

可以看到这个类才是直接使用的，代理类的作用可以作为真正调用之前（或之后）的一种过滤筛选

~~~java
public class Proxy implements GiveGift {

    private Pursuit pursuit;

    public Proxy(SchoolGirl schoolGirl) {
        pursuit = new Pursuit(schoolGirl);
    }

    @Override
    public void giveDolls() {
        //在这里可以做一些数据处理，使得被代理类的逻辑更改
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
~~~



客户端

~~~java
public class Client {

    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("刘冬冬");

        GiveGift Gangan = new Proxy(schoolGirl);

        Gangan.giveChocolate();
        Gangan.giveDolls();
        Gangan.giveFlowers();

    }

}
~~~

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns7.png?raw=true)

### 分析

+ 代理模式实现的关键是代理对象和被代理对象都必须实现同一个接口，就像上述例子中Proxy和Pursuit都实现了GiveGift这个接口，这样才能保证代理对象与被代理对象具有相似的外在行为，而且代理对象必然拥有被代理对象的引用，因为代理对象本质上还是调用被代理对象的实现逻辑进行操作
+ 应用
  1. 远程代理，也就是为一个对象在不同的地址空间提供局部代表。这样就可以隐藏一个对象存在于不同地址空间的事实
  2. 虚拟代理，当需要创建开销很大的对象时，可以使用代理对象充当占个位，比如一个很大的HTML页面，那些未打开的图片框，就是使用了虚拟代理来代替了真实的图片，代理对象存储了图片大大小和路径，这样就可以加快网页的响应速度
  3. 安全代理，用来控制真实对象访问时的权限
  4. 智能指引，指当调用真实对象时，代理处理另外一些事