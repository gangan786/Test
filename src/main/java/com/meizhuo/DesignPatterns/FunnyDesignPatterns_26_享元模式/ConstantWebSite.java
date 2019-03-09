package com.meizhuo.DesignPatterns.FunnyDesignPatterns_26_享元模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_26_享元模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/9 14:33
 * @UpdateUser:
 * @UpdateDate: 2019/3/9 14:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConstantWebSite extends BaseWebSite {

    private String name;

    public ConstantWebSite(String name) {
        this.name = name;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类：" + name + "用户为：" + user.getName());
    }
}
