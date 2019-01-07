# 装饰者模式

当需要将模块化的功能按所需的正确顺序串联起来进行控制时，就可以考虑装饰者模式

最初的版本

~~~java
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void wearTShirts() {
        System.out.print("大T恤 ");
    }

    public void wearBigTrouser() {
        System.out.print("垮裤 ");
    }

    public void wearSneakers() {
        System.out.print("破球鞋 ");
    }

    public void wearSuit() {
        System.out.print("西装");
    }

    public void wearTile() {
        System.out.print("领带 ");
    }

    public void wearLeatherShoes() {
        System.out.print("皮鞋 ");
    }

    public void show() {
        System.out.println("装扮的 " + name);
    }

}
~~~

客户端

~~~java
public class Client {
    public static void main(String[] args) {
        Person gangan = new Person("Gangan");
        System.out.println("第一种装扮：");
        gangan.wearTShirts();
        gangan.wearBigTrouser();
        gangan.show();

        System.out.println("第二种装扮：");
        gangan.wearSuit();
        gangan.wearTile();
        gangan.wearLeatherShoes();
        gangan.show();
    }
}
~~~

------

**用修饰者模式改造之后**

Person类

~~~java
public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("这种装扮的" + name);
    }

}
~~~

Finery类

~~~java
public class Finery extends Person {

    protected Person component;

    public void decorate(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
~~~

 具体服饰类

~~~java
public class BigTrouser extends Finery {
    @Override
    public void show() {
        System.out.println("垮裤 ");
        super.show();
    }
}

public class LeatherShoes extends Finery {

    @Override
    public void show() {
        System.out.println("皮鞋 ");
        super.show();
    }
}

public class Sneakers extends Finery {

    @Override
    public void show() {
        System.out.println("破球鞋 ");
        super.show();
    }
}

public class Suit extends Finery {

    @Override
    public void show() {
        System.out.println("西装 ");
        super.show();
    }
}

public class Tie extends Finery {

    @Override
    public void show() {
        System.out.println("领带 ");
        super.show();
    }
}

public class TShirts extends Finery {
    @Override
    public void show() {
        System.out.println("大T恤 ");
        super.show();
    }
}
~~~

Client 客户端

~~~java
public class Client {

    public static void main(String[] args) {
        Person gangan = new Person("Gangan");
        System.out.println("第一种装扮：");
        Sneakers sneakers = new Sneakers();
        BigTrouser bigTrouser = new BigTrouser();
        TShirts tShirts = new TShirts();

        //开始装饰
        sneakers.decorate(gangan);
        bigTrouser.decorate(sneakers);
        tShirts.decorate(bigTrouser);
        tShirts.show();

        System.out.println("第二种装饰：");
        LeatherShoes leatherShoes = new LeatherShoes();
        Tie tie = new Tie();
        Suit suit = new Suit();
        leatherShoes.decorate(gangan);
        tie.decorate(leatherShoes);
        suit.decorate(tie);
        suit.show();
    }

}
~~~

运行结果：

~~~she
第一种装扮：
大T恤 
垮裤 
破球鞋 
这种装扮的Gangan
第二种装饰：
西装 
领带 
皮鞋 
这种装扮的Gangan
~~~

总结：

+ 装饰者模式是为已用功能动态地添加更多功能的一种方式
+ 使用的时机：在最初的设计中，当系统需要新的功能的时候，是向旧有的类中添加新的代码。这些新加的代码通常装饰了原有类的核心职责或主要行为，比如用西装或者嘻哈服来装饰Gangan，但这种做法的问题在于，他们在主类中加了新的字段，新的方法和新的逻辑，从而增加了主类的复杂度，就像起初的Person类，而这些新加入的东西仅仅是为了满足一些只在某种特定情况才会执行的特殊行为的需求。而装饰模式却提供了一个非常好的解决方案，他把每个要装饰的功能放在单独的类中，并让这个类包装他所要装饰的对象，因此，当需要执行特殊行为时，客户代码就可以在运行时根据需要有选择地，按顺序地使用装饰功能包装对象了
+ 比如说Person的核心职责和主要功能就是show方法，每次增加show方法的装饰逻辑都不会对其产生影响
+ 优点：把类中的装饰功能从类中搬移去除，这样可以简化原有的类，可以有效的把类的核心职责和装饰功能区分开了，而且可以去除相关类中重复的装饰逻辑