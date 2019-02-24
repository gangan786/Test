package com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/24 11:41
 * @UpdateUser:
 * @UpdateDate: 2019/2/24 11:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
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
