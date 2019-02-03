package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/3 22:22
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 22:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class RestState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println("当前时间为：" + work.getHour() + " 下班休息了");
    }
}
