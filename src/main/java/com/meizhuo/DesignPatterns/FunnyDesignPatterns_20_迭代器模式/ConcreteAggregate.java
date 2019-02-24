package com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_20_迭代器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/24 11:46
 * @UpdateUser:
 * @UpdateDate: 2019/2/24 11:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
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
