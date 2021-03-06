# 中介者模式

用一个中介对象来封装一系类的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立的改变他们之间的交互

这里描述的一个场景是各个国家通过联合国安理会这个中介来解决之间的纠纷

+ 优点
  + 中介者的出现减少了各个组件的耦合，可以独立改变和复用
  + 由于把对象如何协作进行了抽象，将中介作为一个独立的概念并将其封装在一个对象中，这样关注的对象就从对象各自本身的行为转移到他们之间的交互上来，也就是站在一个更宏观的角度去看待系统
+ 缺点
  + 由于中介控制了集中化，于是就把交互复杂性变为了中介者的复杂性，这就使得中介者会变得比任何一个分组个体都复杂，优点在某种情况下也会变成缺点