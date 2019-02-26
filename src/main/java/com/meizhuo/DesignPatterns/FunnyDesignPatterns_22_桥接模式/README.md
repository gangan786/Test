# 桥接模式

将抽象部分与他的实现部分分离，使他们可以独立变化

这里描述不同手机品牌和不同手机功能之间的关系

首先来看第一种：按品牌分类结构图

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns22-1.png?raw=true)

第二种：按软件分类结构

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns22-2.png?raw=true)

第三种：使用桥接模式

![](https://github.com/gangan786/Test/blob/master/Image/FunnyDesignPatterns22-3.png?raw=true)

+ 现在如果添加一个新的品牌或者新功能，就不会对其他类产生太大的影响
+ 不要瞎鸡儿使用继承来构建关系导致强耦合
+ 合成/聚合复用原则：尽量使用合成/聚合，尽量不要使用类继承
  + 优先使用对象的合成/聚合将有助于你保持每个类被封装，并集中在单个任务上。这样类和类继承层次会保持较小规模，并且不太可能增长为不可控制的庞然大物。
+ 其实所谓桥接模式就是

