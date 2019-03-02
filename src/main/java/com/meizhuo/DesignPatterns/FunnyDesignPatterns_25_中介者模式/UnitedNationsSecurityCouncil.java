package com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_25_中介者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/2 11:51
 * @UpdateUser:
 * @UpdateDate: 2019/3/2 11:51
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class UnitedNationsSecurityCouncil extends BaseUnitedNations {

    public USACountry usaCountry;

    public IraqCountry iraqCountry;

    /**
     * 将消息转发给对饮的国家
     * @param message
     * @param country
     */
    @Override
    public void declare(String message, BaseCountry country) {
        if (country.equals(usaCountry)) {
            iraqCountry.getMessage(message);
        } else if (country.equals(iraqCountry)) {
            usaCountry.getMessage(message);
        }
    }

}
