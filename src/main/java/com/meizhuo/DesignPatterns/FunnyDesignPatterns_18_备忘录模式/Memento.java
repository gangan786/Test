package com.meizhuo.DesignPatterns.FunnyDesignPatterns_18_备忘录模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_18_备忘录模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/13 21:29
 * @UpdateUser:
 * @UpdateDate: 2019/2/13 21:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Memento {

    private String state;


    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
