package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1;



/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description: 上午工作状态
 * @Author: Gangan
 * @CreateDate: 2019/2/3 18:39
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 18:39
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ForenoonState implements State{
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println("当前时间为：" + work.getHour() + "上午工作，精神百倍");
        }else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
