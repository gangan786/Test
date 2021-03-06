package com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/2 11:43
 * @UpdateUser:
 * @UpdateDate: 2019/3/2 11:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class USACountry extends BaseCountry {

    public USACountry(BaseUnitedNations unitedNations) {
        super(unitedNations);
    }

    public void declare(String message) {
        unitedNations.declare(message,this);
    }

    public void getMessage(String message) {
        System.out.println("美国获得对方消息：" + message);
    }

}
