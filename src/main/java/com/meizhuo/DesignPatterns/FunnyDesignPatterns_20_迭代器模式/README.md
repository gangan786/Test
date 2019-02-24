# 迭代器模式

提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示。

+ 时机：
  + 当需要访问一个聚集对象时，而且不管这些对象是什么都需要遍历的时候
  + 对聚集有多种方式遍历的时候，比如对遍历的顺序有特别的要求时
  + 为不同的聚集结构提供如开始，下一个，是否结束，当前哪一项等统一接口
+ 这种模式普遍都由语言内部实现了
+ 用户只管拿到合适的元素就行，至于怎么找到这个合适元素的方法就对用户透明了，具有良好的封装性，不暴露该对象的内部表示



抽象数据集合

~~~java
public abstract class AbstractAggregate {

    /**
     * 创建迭代器
     * @return
     */
    public abstract AbstractIterator createIterator();

}
~~~

抽象迭代器：定义了针对不同聚集中获取元素的统一接口

~~~java
public abstract class AbstractIterator {
    /**
     * 定义得到开始对象
     *
     * @return
     */
    public abstract Object first();

    /**
     * 得到下一个对象
     *
     * @return
     */
    public abstract Object next();

    /**
     * 是否到结尾
     *
     * @return
     */
    public abstract boolean isDone();

    /**
     * 返回当前对象
     *
     * @return
     */
    public abstract Object currentItem();
}
~~~

具体实现

~~~java
public class ConcreteAggregate extends AbstractAggregate {

    private List<Object> objectList = new ArrayList<>();

    @Override
    public AbstractIterator createIterator() {
        return new ConcreteIterator(this);
    }

    public Object getItem(int index) {
        return objectList.get(index);
    }

    public void setItem(int index,Object item) {
        objectList.add(index, item);
    }

    public int size() {
        return objectList.size();
    }


}

public class ConcreteIterator extends AbstractIterator {

    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.getItem(0);
    }

    @Override
    public Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.size()) {
            ret = aggregate.getItem(current);
        }
        return ret;
    }

    @Override
    public boolean isDone() {
        return current >= aggregate.size();
    }

    @Override
    public Object currentItem() {
        return aggregate.getItem(current);
    }
}
~~~

客户端

~~~java
public class Client {
    public static void main(String[] args) {
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();

        concreteAggregate.setItem(0, "热夜");
        concreteAggregate.setItem(1, "冻朝");
        concreteAggregate.setItem(2, "行李");
        concreteAggregate.setItem(3, "老外");
        concreteAggregate.setItem(4, "内部员工");
        concreteAggregate.setItem(5,"小偷");

        AbstractIterator iterator = concreteAggregate.createIterator();

        Object first = iterator.first();

        while (!iterator.isDone()) {
            System.out.println(iterator.currentItem() + " 请买票");
            iterator.next();
        }


    }
}
~~~

