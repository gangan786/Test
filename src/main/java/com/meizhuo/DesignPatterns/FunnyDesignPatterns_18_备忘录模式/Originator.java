package com.meizhuo.DesignPatterns.FunnyDesignPatterns_18_备忘录模式;

import lombok.ToString;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_18_备忘录模式
 * @ClassName: ${TYPE_NAME}
 * @Description: 这个是某个功能类，要实现保存状态的功能
 * @Author: Gangan
 * @CreateDate: 2019/2/13 21:27
 * @UpdateUser:
 * @UpdateDate: 2019/2/13 21:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
@ToString
public class Originator {

    private String state;

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
