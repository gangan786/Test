



# 建造者模式

如果需要将一个复杂对象的构建与它的表示分离，使得同样的建造过程可以创建不同的表示的意图时，我们就需要“建造者模式”，例如需要构建各种不同的人，但他们都有一个头，一双腿一双手需要构建，但是每种具体的人有各自不同的表示，如瘦高个子，矮胖个子，如果我们使用了建造者模式，那么用户就只需要指定建造类型就可以得到他们，而具体的建造过程和细节就不需知道了，如只要指定构建一个瘦高个子，那么具体的身高体重就可以交给建造者自行构建。

UML

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns13.png?raw=true)

可以看到Builder的作用就是抽象每个具体实现的动作，然后具体的动作的实现就交由继承Builder的实现类去实现，光有Builder还不够，Builder只负责动作的实现，具体的动作的执行顺序执行内容还需要Director来指定实现，所以说Director的执行顺序是固化下来的，不同的Builder实现都必须遵循Director定义的执行顺序执行内容，这就像肯德基里面的标准化操作流程一样，以下是具体实现：

Product	被组装的对象

~~~java
public class Product {

    private List<String> list = new ArrayList<>();

    public void add(String string) {
        list.add(string);
    }

    public void show() {
        for (String s : list) {
            System.out.println(s);
        }
    }

}
~~~

Builder	组装方式的抽象

~~~java
public abstract class Builder {

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getResult();

}
~~~

具体组装方式的具体实现，构建指定要求的Product

~~~java
public class ConcreteBuilderA extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

public class ConcreteBuilderB extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
~~~

Director	组装步骤组装内容固化，这里的意思是组装方式必须包含AB，而且是先执行完A再执行B

~~~java
public class Director {

    public void construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }

}
~~~

Client	客户端

可以看出，我们只需要实现Builder中指定的方法，具体复杂的构建就交给Director的construct()方法便可构建出指定的Product出来

~~~java
public class Client {

    public static void main(String[] args) {
        ConcreteBuilderA concreteBuilderA = new ConcreteBuilderA();
        ConcreteBuilderB concreteBuilderB = new ConcreteBuilderB();

        Director director = new Director();
        director.construct(concreteBuilderA);
        concreteBuilderA.getResult().show();

        director.construct(concreteBuilderB);
        concreteBuilderB.getResult().show();
    }

}
~~~

## 总结

+ 构建者模式是逐步构建产品的，所以构建者的Builder类里的那些建造方法必须足够普遍，以便为各种类型的具体构建者构建
+ Builder，是一个构建Product各个部分的抽象类，是为创建一个Product对象的各个部件指定的抽象接口
+ ConcreteBuilder，是具体建造者，实现Builder接口，构造和装配各个部件
+ Director，指挥者，它是构建一个实现了Builder接口的对象，主要创建一些复杂的对象（Product），这些对象内部的建造顺序通常是稳定的，但对象内部的构建通常面临着复杂的变化
+ 建造者模式的好处就是使得建造代码与表示代码分离，由于建造者隐藏了该产品是如何组装的，所以若需要改变一个产品的内部表示，只需要再定义一个具体的建造者就可以了
+ 建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分以及他们的装配方式时适用的模式

