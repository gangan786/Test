package com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/2 11:56
 * @UpdateUser:
 * @UpdateDate: 2019/3/2 11:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        UnitedNationsSecurityCouncil securityCouncil = new UnitedNationsSecurityCouncil();
        USACountry usaCountry = new USACountry(securityCouncil);
        IraqCountry iraqCountry = new IraqCountry(securityCouncil);

        securityCouncil.usaCountry = usaCountry;
        securityCouncil.iraqCountry = iraqCountry;

        usaCountry.declare("禁止你研发核武器");
        iraqCountry.declare("这是我的自由");
    }

}
