package com.meizhuo.DesignPatterns.FunnyDesignPatterns_22_桥接模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_22_桥接模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/26 10:55
 * @UpdateUser:
 * @UpdateDate: 2019/2/26 10:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class BasePhoneBrand  {

    protected BasePhoneSoft phoneSoft;

    protected String name;

    public BasePhoneBrand(String name) {
        this.name = name;
    }

    public void setPhoneSoft(BasePhoneSoft phoneSoft) {
        this.phoneSoft = phoneSoft;
    }

    public abstract void run();

}
