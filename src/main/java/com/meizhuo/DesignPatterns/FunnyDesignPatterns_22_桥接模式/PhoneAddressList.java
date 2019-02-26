package com.meizhuo.DesignPatterns.FunnyDesignPatterns_22_桥接模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_22_桥接模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/26 10:54
 * @UpdateUser:
 * @UpdateDate: 2019/2/26 10:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class PhoneAddressList extends BasePhoneSoft {
    @Override
    public void run(String name) {
        System.out.println(name + " 运行手机通讯录");
    }
}
