package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/3 22:06
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 22:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class NoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.println("当前时间为：" + work.getHour() + " 饿了，犯困，午睡");
        } else {
            work.setState(new AfterNoonState());
            work.writeProgram();
        }
    }
}
