# 工厂方法模式

先看看以前计算器的简单工厂模式实现

![简单工厂模式](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns1.png?raw=true)

那么换成工厂方法模式来重构的话是如下的结构图

![工厂方法模式](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns8-2.png?raw=true)

+ 具体的做法就是将每种运算类都专门对应工厂实现类来产生，不像以前的简单工厂模式，统一由一个具体的工厂类统一产生对应的运算类

+ 在简单工厂里，如果添加一个M的N次方需求，是先加 “求M数的N次方” 功能类，然后去更改工厂方法，当中加Case语句来判断，如果使用了工厂方法，要加功能类，要加对应的工厂实现类，然后修改客户端

+ 简单工厂模式的最大优点在于工厂类中包含了必要的逻辑判断，根据客户端的选择条件动态实例化相关的类，对于客户端来说，去除了具体产品的依赖。但对于简单工厂方法模式来说，如果要加一个 “求M数的N次方” 的功能，我们是一定要给运算工厂类的方法里面添加case的分支条件，修改原有的类，这可不是什么好办法，这等于就说不但对拓展开放了，对修改也开放了，这就违背了开放—封闭原则

+ 根据依赖倒转原则，我们把工厂类抽象出一个接口，这个接口只有一个方法，就是创建抽象产品的工厂方法。然后，所有的要生产具体类的工厂，就去实现这个接口，这样，一个简单工厂模式的工厂类，变成了一个工厂抽象接口和多个具体生成对象的工厂，于是当我们要增加 “求M数的N次方” 的功能时，就不需要改原有的工厂类了，只需要增加此功能的运算类和相应的工厂类就可以了

+ 工厂方法模式实现时，客户端需要决定实例化哪一个工厂来实现运算类，选择判断问题还是存在的，也就是说，工厂方法把简单工厂的内部逻辑判断移到了客户端代码来进行。你要想加功能，本来是改工厂类的，而现在是修改客户端

+ 工厂方法克服简单工厂方法违背开放—封闭原则的缺点，又保持了封装对象的创建过程的优点，缺点就是每增加一个产品，就需要加一个产品工厂的类，增加了额外的开发量

+ 以下是另一个场景实现，志愿者和大学生都学雷锋做好事，使用工厂方法模式产生具体的雷锋实现类

  UML

  ![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns8.png?raw=true)

  LeiFeng 雷锋接口

  ~~~java
  @Data
  public abstract class LeiFeng {
  
      private String name;
  
      private String identity;
  
      /**
       * 扫
       */
      public abstract void sweepSomething();
  
      /**
       * 洗
       */
      public abstract void washSomething();
  
      /**
       * 买
       */
      public abstract void buySomething();
  
  }
  ~~~

  具体做好事的实现类

  Volunteer

  ~~~java
  public class Volunteer extends LeiFeng {
  
      public Volunteer(String name) {
          setIdentity("志愿者");
          setName(name);
      }
  
      @Override
      public void sweepSomething() {
          System.out.println(getIdentity() + getName() + " 扫室外");
      }
  
      @Override
      public void washSomething() {
          System.out.println(getIdentity() + getName() + " 洗厨房");
      }
  
      @Override
      public void buySomething() {
          System.out.println(getIdentity() + getName() + " 买油盐");
      }
  }
  ~~~

  Undergraduate

  ~~~java
  public class Undergraduate extends LeiFeng {
  
      public Undergraduate(String name) {
          setIdentity("大学生");
          setName(name);
      }
  
      @Override
      public void sweepSomething() {
          System.out.println(getIdentity() + getName() + " 扫室内");
      }
  
      @Override
      public void washSomething() {
          System.out.println(getIdentity() + getName() + " 洗衣服");
      }
  
      @Override
      public void buySomething() {
          System.out.println(getIdentity() + getName() + " 卖大米");
      }
  }
  ~~~

  IFactory 工厂抽象

  ~~~java
  public interface IFactory {
      /**
       * 所有工厂实现类的统一接口
       *
       * @param name
       * @return
       */
      LeiFeng createLeiFeng(String name);
  }
  ~~~

  对应的工厂实现类

  VolunteerFactory

  ~~~java
  public class VolunteerFactory implements IFactory {
      @Override
      public LeiFeng createLeiFeng(String name) {
          return new Volunteer(name);
      }
  }
  ~~~

  UndergraduateFactory

  ~~~java
  public class UndergraduateFactory implements IFactory {
  
      @Override
      public LeiFeng createLeiFeng(String name) {
          return new Undergraduate(name);
      }
  }
  ~~~

  Client 客户端

  ~~~java
  public class Client {
  
      public static void main(String[] args) {
          IFactory factory = new UndergraduateFactory();
          LeiFeng stuA = factory.createLeiFeng("张三");
          stuA.buySomething();
          stuA.sweepSomething();
          stuA.washSomething();
  
          factory = new VolunteerFactory();
          LeiFeng stuB = factory.createLeiFeng("李四");
          stuB.buySomething();
          stuB.sweepSomething();
          stuB.washSomething();
  
      }
  
  }
  ~~~
