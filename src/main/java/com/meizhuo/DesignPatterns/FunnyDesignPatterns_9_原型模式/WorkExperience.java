package com.meizhuo.DesignPatterns.FunnyDesignPatterns_9_原型模式;

import lombok.Getter;
import lombok.Setter;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_9_原型模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/11 22:31
 * @UpdateUser:
 * @UpdateDate: 2019/1/11 22:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */

public class WorkExperience implements Cloneable {

    @Getter
    @Setter
    private String workDate;

    @Getter
    @Setter
    private String company;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workDate='" + workDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
