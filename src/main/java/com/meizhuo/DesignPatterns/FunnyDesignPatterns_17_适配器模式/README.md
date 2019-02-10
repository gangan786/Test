# 适配器模式

这里描述一个场景：一个中国球员去到NBA打篮球，但由于语言不通听不懂英语，只能先借助翻译。转换成代码描述就是：一个类由于没有实现接口规范（后期不可重现实现），但是却要求必须按照接口规范进行

具体操作流程是：定义一个适配器（Adapter）去实现该接口（因为要求按接口规范），在Adapter里面引用不懂英语的球员，然后在实现的方法里面调用外籍球员类似的方法。

具体看如下代码：

这个是要求实现的接口规范

~~~java
public abstract class Player {

    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void Attack();

    public abstract void Defense();
}
~~~

这是未能实现接口的类

可以看到接口规范与其功能类似，但是如果想要实现接口规范，可以使用适配器模式

~~~java
public class ForeignCenter {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void 进攻(){
        System.out.println("外籍中锋 " + name + " 进攻");
    }

    public void 防守(){
        System.out.println("外籍中锋 " + name + " 防守");
    }
}
~~~

适配器

可以看到这里引用了ForeignCenter，并实现了接口规范来调用正真的方法实现者，这样客户端就可以像其它按照规范编写的代码一样来调用

~~~java
public class TranslatorAdapter extends Player {

    private ForeignCenter foreignCenter;

    public TranslatorAdapter(String name) {
        super(name);
        foreignCenter = new ForeignCenter();
        foreignCenter.setName(name);
    }

    @Override
    public void Attack() {
        foreignCenter.进攻();
    }

    @Override
    public void Defense() {
        foreignCenter.防守();
    }
}
~~~

客户端

~~~java
public class Client {

    public static void main(String[] args) {
        Player gangan = new Forwards("Gangan");

        Player dDong = new Guards("DDong");

        //可以看到 没有让ForeignCenter实现Player接口，通过Adapter模式依然可以保证接口规范
        Player center = new TranslatorAdapter("热夜");

        gangan.Attack();
        dDong.Defense();


        center.Defense();
        center.Attack();
    }

}
~~~

其它实现接口规范的实体类

~~~java
public class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("前锋 " + name + " 进攻");
    }

    @Override
    public void Defense() {
        System.out.println("前锋 " + name + " 防守");
    }
}

public class Guards extends Player {
    public Guards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("后卫 " + name + " 进攻");
    }

    @Override
    public void Defense() {
        System.out.println("后卫 " + name + " 防守");
    }
}
~~~

## 总结

+ 适配器模式跟外观模式有点类似，都是对方法调用的进一步封装，不同的是适配器模式强调的是接口保持规范
+ 适配器模式，将一个类的接口转换成客户希望的另一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
+ 时机：当系统的数据和行为都正确，但接口不符时，我们应该考虑用适配器，目的是使控制范围之外的一个原有对象与某个接口匹配，适配器模式主要应用于希望复用一些现存的类，但接口又与复用环境要求不一致时，适配器是个合适的选择
+ 适配器也是无奈之举，大部分的使用场景是在开发后期或维护期