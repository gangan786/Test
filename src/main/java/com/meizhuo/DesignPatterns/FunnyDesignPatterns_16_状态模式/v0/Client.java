package com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v0;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_16_状态模式.v0
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/3 18:18
 * @UpdateUser:
 * @UpdateDate: 2019/2/3 18:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        Work emergencyProject = new Work();
        emergencyProject.setHour(9);
        emergencyProject.writeProgram();
        emergencyProject.setHour(10);
        emergencyProject.writeProgram();
        emergencyProject.setHour(12);
        emergencyProject.writeProgram();
        emergencyProject.setHour(13);
        emergencyProject.writeProgram();
        emergencyProject.setHour(14);
        emergencyProject.writeProgram();
        emergencyProject.setHour(17);

        //设置任务完成
        emergencyProject.setFinish(true);
        emergencyProject.writeProgram();
        emergencyProject.setHour(19);
        emergencyProject.writeProgram();
        emergencyProject.setHour(22);
        emergencyProject.writeProgram();

    }
}
