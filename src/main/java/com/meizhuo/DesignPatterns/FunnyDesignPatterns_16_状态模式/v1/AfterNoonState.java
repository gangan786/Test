package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/3 22:14
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 22:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class AfterNoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17) {
            System.out.println("当前时间为：" + work.getHour() + " 下午状态还不错继续努力");
        } else {
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
