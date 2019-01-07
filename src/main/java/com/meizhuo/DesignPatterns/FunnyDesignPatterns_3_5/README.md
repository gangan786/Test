### 单一职责原则

+ 单一职责原则，简单来说就是功能要单一，准确的解释是：就一个类而言，应该仅有一个引起他变化的原因，或者说原因尽量少，这样才能保证当需求发生变化的时候，改动的代价最小化。
+ 如果一个类承担的职责过多，就等于把这些职责耦合在一起，一个职责的变化可能会削弱或者抑制这个类完成其他职责的能力。这种耦合会导致脆弱的设计，当变化发生时，设计会遭遇到意想不到的破坏。
+ 软件设计真正要做的许多内容，就是发现职责并把那些职责相互分离。其实要去判断是否应分离出类来，也不难，那就是你能够想多多于一个动机去改变一个类，那么这个类就具有多于一个的职责。



### 开放—封闭原则

+ 开放—封闭原则，是说软件实体（类，模块，函数等）应该可以扩展，但是不可修改，特征：对于拓展是开放的，对于更改是封闭的。达到在面对需求的改变可以保持相对稳定的目的，从而使得系统可以在第一个版本以后不断推出新的版本，简洁来讲就是多扩展未有的，少修改已有的
+ 无论模块是多么的封闭，都会存在一些无法对之封闭的变化。既然不可能完全封闭，设计人员对于他设计的模块应该对哪种变化封闭做出选择，必须先猜测出最有可能发生变化的种类，然后构造抽象来隔离那些变化。但是很难预先猜测，可以在发生小变化时，就及时去想办法应对发生更大变化的可能。
+ 面对需求，对程序的改动是通过增加新代码进行的，而不是更改现有的代码，这就是开放—封闭原则的精神所在
+ 尽可能在开发工作开展不久就可以知道可能发生的变化。查明可能发生变化所等待的时间越长，要创建正确的抽象就越难
+ 开放—封闭原则是面向对象设计的核心所在。遵循这个原则可以带来面向对象所声称的巨大好处，也就是可维护，可拓展，可复用，灵活性好。开发人员应该仅对程序中呈现出频繁变化的那些部分作出抽象，然而，对于应用程序中每个部分都刻意的进行抽象同样不是一个好主意。拒绝不成熟的抽象和抽象本身一样重要，过犹不及



### 依赖倒转原则

+ 高层模块不应该依赖低层模块。两个都应该依赖抽象
+ 抽象不应该依赖细节，细节应该依赖抽象

在面向过程的开发中，为了使得常用代码可以复用，一般都会把这些常用代码写成许许多多函数的程序库，这样我们在做新项目时，去调用这些低层的函数就可以了。比如我们做的项目要访问数据库，所以我们就把访问数据库的代码写成了函数，每次做新项目时就去调用这些函数。这就叫高层模块依赖低层模块。

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns5-1.png?raw=true)

##### 里氏代换原则

+ 一个软件实体如果使用的是一个父类的话，那么一定适用于其子类，而且他觉察不出父类对象和子类对象的区别。也就是说，在软件里面，把父类都替换成他的子类，程序的行为没有变化

+ 继承，子类继承了父类，所以子类可以以父类的身份出现

+ 由于子类的可替换性才使得父类类型的模块在无需修改的情况下就可以扩展

+ **高层模块不应该依赖低层模块，两个都应该依赖抽象，如下图**

  ![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns5-2.png?raw=true)

+ 依赖倒转其实可以说是面向对象设计的标志，用哪种语言编写程序不重要，如果编写时考虑的都是如何针对抽象编程而不是针对细节编程，即程序中所有的依赖关系都终止于抽象类或者接口，那就是面向对象的设计，反之那就是过程化的设计了。