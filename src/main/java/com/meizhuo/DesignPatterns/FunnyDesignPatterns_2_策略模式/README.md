### 策略模式  这里实现一个收银台程序，营业员根据客户所购买商品的单价和数量，向客户收费



#### v1.0

~~~java
public class Client {

    public static void main(String[] args) {
        Double total = new Double(0);
        ArrayList<String> commodityList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入单价");
            String price = scanner.nextLine();//获取单价
            if ("quit".equals(price)) {
                break;
            }
            System.out.println("请输入数量");
            String num = scanner.nextLine();//获取数量
            Double singleCommodity = Double.valueOf(price) * Double.valueOf(num);//直接相乘获取总价
            commodityList.add("单价：" + price + " 数量：" + num + " 总价为："
                    + singleCommodity);//在商品列表中添加该商品信息
            total = total + singleCommodity;//计算总价
            showCommodityList(commodityList);
        }

        System.out.println("所有商品的总价为：" + total);
    }

    private static void showCommodityList(ArrayList<String> commodityList) {
        for (String s : commodityList) {
            System.out.println(s);
        }
    }
}
~~~



问题：

+ 增加一个需求：商品打八折



#### v1.1

增加打折的功能

~~~java
public class Client {

    public static void main(String[] args) {
        Double total = new Double(0);
        ArrayList<String> commodityList = new ArrayList<>();
        ArrayList<String> cashWays = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入单价");
            String price = scanner.nextLine();
            if ("quit".equals(price)) {
                break;
            }
            System.out.println("请输入数量");
            String num = scanner.nextLine();
            showCashWays(cashWays);
            String way = scanner.nextLine();
            double singleCommodity= 0;
            switch (way) {
                case "1":
                    singleCommodity = Double.valueOf(price) * Double.valueOf(num);
                    break;
                case "2":
                    singleCommodity = Double.valueOf(price) * Double.valueOf(num) * 0.8;
                    break;
                case "3":
                    singleCommodity = Double.valueOf(price) * Double.valueOf(num) * 0.7;
                    break;
                case "4":
                    singleCommodity = Double.valueOf(price) * Double.valueOf(num) * 0.5;
                default:
                    break;

            }

            commodityList.add("单价：" + price
                    + " 数量：" + num
                    +" 方式："+cashWays.get(Integer.valueOf(way)-1)
                    + " 总价为：" + singleCommodity);
            total = total + singleCommodity;
            showCommodityList(commodityList);
        }

        System.out.println("所有商品的总价为：" + total);
    }

    private static void showCommodityList(ArrayList<String> commodityList) {
        for (String s : commodityList) {
            System.out.println(s);
        }
    }

    private static void showCashWays(ArrayList<String> cashWays) {
        if (cashWays.isEmpty()){
            cashWays.add("1.正常收费");
            cashWays.add("2.打八折");
            cashWays.add("3.打七折");
            cashWays.add("4.打五折");
        }
        for (String way : cashWays) {
            System.out.println(way);
        }
    }


}
~~~

问题：

+ 增加满减的功能，例如满300减100
+ 面向对象的编程，并不是类越多越好，类的划分是为了封装，但分类的基础是抽象，具有相同属性和功能的对象的抽象集合才是类，所以把打折抽象出来，具体打几折有参数决定，再把满减抽象出来，具体满多少减多少由具体的参数决定



以下是具体的代码结构图：

![UML](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns2-1.png?raw=true)

**现金抽象类**

~~~java
public abstract class BaseCashSuper {
    /**
     * 现金收取超类的抽象方法
     * @param money 原价
     * @return 当前价
     */
    public abstract double acceptCash(double money);
}
~~~

**正常收费子类**

~~~java
public class CashNormal extends BaseCashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
~~~

**打折收费子类**

~~~java
public class CashRebate extends BaseCashSuper {

    private double moneyRebate = 0;

    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.valueOf(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money * (moneyRebate * 0.1);
    }
}
~~~

**返利收费子类**

~~~java
public class CashReturn extends BaseCashSuper {

    private double moneyCondition;
    private double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money > moneyCondition) {
            result = money - (int) (money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
~~~

**现金收费工厂类**

~~~java
public class CashFactory {

    public static BaseCashSuper createCashAccept(String type) {
        BaseCashSuper baseCashSuper = null;
        switch (type) {
            case "1.正常收费":
                baseCashSuper = new CashNormal();
                break;
            case "2.满300返100":
                baseCashSuper = new CashReturn(300, 100);
                break;
            case "3.打八折":
                baseCashSuper = new CashRebate("8");
                break;
            default:
                break;
        }
        return baseCashSuper;
    }

}
~~~

**客户端**

~~~java
public class Client {

    public static void main(String[] args) {
        Double total = new Double(0);
        ArrayList<String> commodityList = new ArrayList<>();
        ArrayList<String> cashWays = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入单价");
            String price = scanner.nextLine();
            if ("quit".equals(price)) {
                break;
            }
            System.out.println("请输入数量");
            String num = scanner.nextLine();
            showCashWays(cashWays);
            String way = scanner.nextLine();
            double singleCommodity= 0;
            BaseCashSuper accept = CashFactory.createCashAccept(cashWays.get(Integer.valueOf(way) - 1));
            singleCommodity = accept.acceptCash(Double.valueOf(price) * Double.valueOf(num));

            commodityList.add("单价：" + price
                    + " 数量：" + num
                    +" 方式："+cashWays.get(Integer.valueOf(way)-1)
                    + " 总价为：" + singleCommodity);
            total = total + singleCommodity;
            showCommodityList(commodityList);
        }

        System.out.println("所有商品的总价为：" + total);
    }

    private static void showCommodityList(ArrayList<String> commodityList) {
        for (String s : commodityList) {
            System.out.println(s);
        }
    }

    private static void showCashWays(ArrayList<String> cashWays) {
        if (cashWays.isEmpty()){
            cashWays.add("1.正常收费");
            cashWays.add("2.满300返100");
            cashWays.add("3.打八折");
        }
        for (String way : cashWays) {
            System.out.println(way);
        }
    }
}
~~~

现在对于其他需求可以简单处理了，

+ 如添加打打五折和满500送200的促销活动，则只要在收费对象生成工厂（CashFactory）中添加两个条件，在收费选项里增加对应的两项就行了
+ 如过添加的是一个积分算法，满100得积分10点，那么就需要一个积分类继承BaseCashSuper，在他的构造方法里面传入两个参数：条件和返点，然后在收费对象生成工厂类增加满100返10点的分支条件，再到界面稍微改动就行了
+ 问题：由于此工厂模式包括了所有的收费方式，商场是可能经常的更改打折返现额度，每次维护或者扩展收费方式都要改动这个工厂，以致代码需要重新编译部署，这是糟糕的。面对算法的时常变动，应该有更好的办法。



#### v2.0

**策略模式**

具体代码结构图：

![UML](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns2-2.png?raw=true)

可以看到客户端只和CashContent打交道了，耦合度更低

**CashContent**

~~~java
public class CashContext {

    private BaseCashSuper baseCashSuper = null;


    public CashContext(String way) {
        switch (way) {
            case "1.正常收费":
                baseCashSuper = new CashNormal();
                break;
            case "2.满300返100":
                baseCashSuper = new CashReturn(300, 100);
                break;
            case "3.打八折":
                baseCashSuper = new CashRebate("8");
            default:
                break;
        }
    }

    public double getResult(double money) {
        return baseCashSuper.acceptCash(money);
    }

}
~~~

客户端

~~~java
public class Client {

    public static void main(String[] args) {
        Double total = new Double(0);
        ArrayList<String> commodityList = new ArrayList<>();
        ArrayList<String> cashWays = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入单价");
            String price = scanner.nextLine();
            if ("quit".equals(price)) {
                break;
            }
            System.out.println("请输入数量");
            String num = scanner.nextLine();
            showCashWays(cashWays);
            String way = scanner.nextLine();
            double singleCommodity = 0;

            CashContext cashContext = new CashContext(cashWays.get(Integer.valueOf(way) - 1));
            singleCommodity = cashContext.getResult(Double.valueOf(price) * Double.valueOf(num));

            commodityList.add("单价：" + price
                    + " 数量：" + num
                    + " 方式：" + cashWays.get(Integer.valueOf(way) - 1)
                    + " 总价为：" + singleCommodity);
            total = total + singleCommodity;
            showCommodityList(commodityList);
        }

        System.out.println("所有商品的总价为：" + total);
    }

    private static void showCommodityList(ArrayList<String> commodityList) {
        for (String s : commodityList) {
            System.out.println(s);
        }
    }

    private static void showCashWays(ArrayList<String> cashWays) {
        if (cashWays.isEmpty()) {
            cashWays.add("1.正常收费");
            cashWays.add("2.满300返100");
            cashWays.add("3.打八折");
        }
        for (String way : cashWays) {
            System.out.println(way);
        }
    }


}
~~~



#### 策略模式解析

+ 策略模式是一种定义一系类算法的方法，从概念上来看，所有这些算法完成的都是相同的工作，只是实现不一样，他可以以相同的方式调用所有的算法，减少了各种算法类与使用算法类之间的耦合
+ 策略模式的Strategy类层次为Context定义了一系类的可供重用的算法或行为。继承有助于汲取出算法中的公共功能。例如在上述的代码中的公共功能就是获得计算费用的结果getResult()，这使得有了抽象类BaseCaseSuper
+ 策略模式的优点简化了单元测试，因为每个算法实现都有自己的类，可以通过自己接口单独测试，修改任何一个算法不会影响其他的算法
+ 策略模式封装了变化
+ 只要在分析过程中听到需要在不同时间应用不同的业务规则，就可以考虑使用策略模式处理这种变化的可能性
+ 在CashContent使用到了switch，所以当添加一种算法时仍需更改switch，可以使用反射的方法降低改动代码的代价（抽象工厂模式  ）