package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v0;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/3 18:03
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 18:03
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Work {

    private int hour;

    private boolean finish;

    public void writeProgram() {
        if (hour < 12) {
            System.out.println("当前时间为：" + hour + " 上午工作，精神百倍");
        } else if (hour < 13) {
            System.out.println("当前时间：" + hour + " 饿了，午饭；犯困，午休");
        } else if (hour < 17) {
            System.out.println("当前时间为：" + hour + " 下午状态还不错，继续努力");
        } else {
            if (finish) {
                System.out.println("当前时间为：" + hour + " 下班回家了");
            } else {
                if (hour < 21) {
                    System.out.println("当前时间为：" + hour + " 加班，感觉身体被掏空");
                } else {
                    System.out.println("当前时间为：" + hour + " 拒绝熬夜，睡觉");
                }
            }
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
