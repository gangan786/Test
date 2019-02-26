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
public class PhoneBrandMei extends BasePhoneBrand {

    public PhoneBrandMei(String name) {
        super(name);
    }

    @Override
    public void run() {
        phoneSoft.run(name);
    }
}
