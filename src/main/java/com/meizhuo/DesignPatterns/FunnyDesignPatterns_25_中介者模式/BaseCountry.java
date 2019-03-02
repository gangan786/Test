package com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/2 11:41
 * @UpdateUser:
 * @UpdateDate: 2019/3/2 11:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class BaseCountry {

    protected BaseUnitedNations unitedNations;

    public BaseCountry(BaseUnitedNations unitedNations) {
        this.unitedNations = unitedNations;
    }
}
