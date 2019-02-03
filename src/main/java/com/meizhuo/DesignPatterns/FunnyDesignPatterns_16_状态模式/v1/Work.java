package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/3 18:44
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 18:44
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Work {

    private State current;

    private double hour;

    private boolean finish = false;

    public Work() {
        current = new ForenoonState();
    }

    public void writeProgram(){
        current.writeProgram(this);
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setState(State state){
        this.current=state;
    }
}
