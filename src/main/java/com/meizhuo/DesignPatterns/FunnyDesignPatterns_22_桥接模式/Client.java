package com.meizhuo.DesignPatterns.FunnyDesignPatterns_22_桥接模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_22_桥接模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/26 11:00
 * @UpdateUser:
 * @UpdateDate: 2019/2/26 11:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        BasePhoneBrand mi = new PhoneBrandMi("魅族");
        mi.setPhoneSoft(new PhoneGame());
        mi.run();

        PhoneBrandMei mei = new PhoneBrandMei("小米");
        mei.setPhoneSoft(new PhoneAddressList());
        mei.run();
    }

}
