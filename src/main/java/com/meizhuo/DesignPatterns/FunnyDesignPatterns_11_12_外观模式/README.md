# 外观者模式

迪米特原则：如果两个类不必彼此直接通信，那么这两个类就不应当发生直接的相互作用。如果其中一个类需要调用另一个类的某一个方法的话，可以通过第三者转发这个调用。在类的结构设计上，每一个类都应当尽量降低成员的访问权限，即类之间的松耦合

这里描述一个场景：对于股票投资，需要对多只股票具有较深的研究，更需要一些专业知识，这对于业余的一些散户来说是具有较高的门槛，所以为了减低门槛基金这种方式就具有了市场，这种基金代理的方式就跟外观者模式的设计思想很相似

具体实现代码如下所示：

定义资产行为

~~~java
public interface AssetsBehave {

    /**
     * 描述资产卖出的行为
     */
    void sell();

    /**
     * 描述资产买入的行为
     */
    void buy();

}
~~~

股票A

~~~java
public class StockA implements AssetsBehave {


    @Override
    public void sell() {
        System.out.println("股票A卖出");
    }

    @Override
    public void buy() {
        System.out.println("股票A买入");
    }
}
~~~

股票B

~~~java
public class StockB implements AssetsBehave {
    @Override
    public void sell() {
        System.out.println("股票B卖出");
    }

    @Override
    public void buy() {
        System.out.println("股票B买入");
    }
}
~~~

国债

~~~java
public class NationalDebt implements AssetsBehave {
    @Override
    public void sell() {
        System.out.println("国债卖出");
    }

    @Override
    public void buy() {
        System.out.println("国债买入");
    }
}
~~~

没有使用外观模式的时候客户端的行为是wayA

~~~java
public class Client {

    public static void main(String[] args) {
        wayA();
        System.out.println("---------------------------------------------");
        wayB();
    }

    private static void wayB() {
        Fund fund = new Fund();
        fund.buyFund();
        fund.sellFund();
    }

    private static void wayA() {
        AssetsBehave stockA = new StockA();
        AssetsBehave stockB = new StockB();
        AssetsBehave nationalDebt = new NationalDebt();

        stockA.buy();
        stockB.buy();
        nationalDebt.buy();

        stockA.sell();
        stockB.sell();
        nationalDebt.sell();
    }

}
~~~

没引入基金时的UML图

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns12-1.png?raw=true)

现在使用外观者模式，即引入基金

~~~java
public class Fund {

    private AssetsBehave stockA;

    private AssetsBehave stockB;

    private AssetsBehave nationalDebt;

    public Fund() {
        stockA = new StockA();
        stockB = new StockB();
        nationalDebt = new NationalDebt();
    }

    public void buyFund(){
        stockA.buy();
        stockB.buy();
        nationalDebt.buy();
    }

    public void sellFund(){
        stockA.sell();
        stockB.sell();
        nationalDebt.sell();
    }


}
~~~

引入基金后，客户端的行为就是wayB，UML图

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns12-2.png?raw=true)

## 总结

外观模式就是将复杂的逻辑调用封装成简单的调用方式，对于复杂难以维护的老系统更是如此