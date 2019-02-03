package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/3 22:19
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 22:19
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class EveningState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinish()) {
            work.setState(new RestState());
            work.writeProgram();
        }else {
            if (work.getHour() < 21) {
                System.out.println("当前时间为：" + work.getHour() + " 加班中，感觉身体被掏空");
            } else {
                work.setState(new SleepState());
                work.writeProgram();
            }
        }
    }
}
