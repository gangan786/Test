package com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:  这个是没有实现Player接口的运动员，但任然要求按照Player接口的规范使用，这样的话
 *               就要使用适配器模式了
 * @Author: Gangan
 * @CreateDate: 2019/2/10 10:49
 * @UpdateUser:
 * @UpdateDate: 2019/2/10 10:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ForeignCenter {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void 进攻(){
        System.out.println("外籍中锋 " + name + " 进攻");
    }

    public void 防守(){
        System.out.println("外籍中锋 " + name + " 防守");
    }
}
