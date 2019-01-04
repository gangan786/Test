## 这里提一个面试题：请用C++,java,C#或VB.NET任意一种面向对象语言实现一个计算器控制台程序，要求输入两个数和运算符号得到结果

###V  1.0

这个是最初的版本 

~~~java
public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A");
        String A = scanner.nextLine();
        System.out.println("请选择运算符号：+,-,*,/");
        String B = scanner.nextLine();
        System.out.println("请输入数字B");
        String C = scanner.nextLine();
        String D = "";
        if ("+".equals(B)) {
            D = String.valueOf(Double.valueOf(A) + Double.valueOf(C));
        }
        if ("-".equals(B)) {
            D = String.valueOf(Double.valueOf(A) - Double.valueOf(C));
        }
        if ("*".equals(B)) {
            D = String.valueOf(Double.valueOf(A) * Double.valueOf(C));
        }
        if ("/".equals(B)) {
            D = String.valueOf(Double.valueOf(A) / Double.valueOf(C));
        }
        System.out.println("结果是：" + D);
    }
}

~~~

出现的问题：

+ 变量命名不规范，如A B C D
+ 判断分支，意味着每个条件都要做出判断，等于做了三次无用功
+ 如果除数为0直接程序崩溃，不够健壮



### V 2.0

这段代码是对上述问题提出的改进

~~~java
public class Program2 {
    public static void main(String[] args) {

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字A");
            String numA = scanner.nextLine();
            System.out.println("请选择运算符号：+,-,*,/");
            String operate = scanner.nextLine();
            System.out.println("请输入数字B");
            String numB = scanner.nextLine();
            String result = "";
            switch (operate) {
                case "+":
                    result = String.valueOf(Double.valueOf(numA) + Double.valueOf(numB));
                    break;
                case "-":
                    result = String.valueOf(Double.valueOf(numA) - Double.valueOf(numB));
                    break;
                case "*":
                    result = String.valueOf(Double.valueOf(numA) * Double.valueOf(numB));
                    break;
                case "/":
                    if (Double.valueOf(numB) != 0) {
                        result = String.valueOf(Double.valueOf(numA) / Double.valueOf(numB));
                    } else {
                        result = "除数不能为0";
                    }

                    break;
                default:
                    result = "未知的运算符号";
            }
            System.out.println("结果是：" + result);
        }
        catch (Exception e){
            System.out.println("输入错误：" + e.getMessage());
        }


    }
}
~~~



虽然基本上实现了计算器的功能，但是没有用到面向对象的思想，这是所有编程初学者的问题，遇到问题先用计算机能理解的逻辑来看待解决问题，但这样思维只满足了我们当前的需求，程序不易维护，不易扩展，更不容易复用。可以考虑使用面想对象的特点进行改造：封装，继承，多态，来降低耦合度。



### V 3.0

这个是降低耦合度，使业务逻辑与界面逻辑分开

Operation 运算业务逻辑

~~~java
public class Operation {
    public static double getResult(double numA, double numB, String operation) {
        double result = 0d;
        switch (operation) {
            case "+":
                result = numA+numB;
                break;
            case "-":
                result = numA-numB;
                break;
            case "*":
                result = numA*numB;
                break;
            case "/":
                    result = numA/numB;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
~~~

Client 客户端

~~~java
public class Client {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字A");
            String numA = scanner.nextLine();
            System.out.println("请选择运算符号：+,-,*,/");
            String operate = scanner.nextLine();
            System.out.println("请输入数字B");
            String numB = scanner.nextLine();
            String result = "";
            System.out.println("结果是：" + Operation.getResult(Double.valueOf(numA), Double.valueOf(numB), operate));

        } catch (Exception e) {
            System.out.println("你的输入有错误" + e.getMessage());
        }

    }
}
~~~

这样就把页面与业务分离了（这里使用了面向对象的封装），其他WEB，控制台，手机等平台也可以使用业务逻辑，这样就实现了代码的复用。

问题：

+ 是否做到灵活的可修改和拓展
+ 如果增加一个开根运算，那就只能在Operation里面改，这就出现了一个问题，明明只涉及一个开根运算的添加，却要其他加减乘除运算代码同时参加编译，如果不小心把加法修改了，那就发生了严重的生产事故,使得原来原有的运行良好的功能代码发生了变化



### V 4.0

这里对每种运算都做了抽离，使得增加一种运算不会对其他运算产生影响，对其他运算进行隔离

抽象类 Operation

~~~java
public abstract class Operation {

    private double numA = 0;
    private double numB = 0;

    /**
     * 获取运算结果
     * @return 结果
     */
    public abstract double getResult();

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }
}
~~~

加减乘除的实现类

~~~java
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getNumA()+getNumB();
    }
}

public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return getNumA()-getNumB();
    }
}

public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return getNumA()*getNumB();
    }
}

public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (getNumB() == 0) {
            throw new RuntimeException("除数不能为0");
        } else {
            return getNumA() / getNumB();
        }
    }
}

~~~

那么如何决定具体使用哪个类，这里就要使用**工厂模式**了，根据不同的运算符号产生对应的运算实现类

~~~java
public class OperationFactory {
    public static Operation createOperation(String operation) {
        Operation ope = null;
        switch (operation) {
            case "+":
                ope = new OperationAdd();
                break;
            case "-":
                ope = new OperationSub();
                break;
            case "*":
                ope = new OperationMul();
                break;
            case "/":
                ope = new OperationDiv();
                break;
            default:
                return null;
        }
        return ope;
    }
}
~~~

所以按照上述模式，当增加一个运算时，除了使该类继承Operation外还需要往工厂里面添加具体的实现类

客户端 Client

~~~java
public class Client {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字A");
            String numA = scanner.nextLine();
            System.out.println("请选择运算符号：+,-,*,/");
            String operate = scanner.nextLine();
            System.out.println("请输入数字B");
            String numB = scanner.nextLine();
            Operation operation = OperationFactory.createOperation(operate);
            operation.setNumA(Double.valueOf(numA));
            operation.setNumB(Double.valueOf(numB));
            System.out.println("结果是：" + operation.getResult());
        } catch (Exception e) {
            System.out.println("你的输入有错误：" + e.getMessage());
        }
    }
}
~~~

具体的类结构图：

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns1.png?raw=true)



