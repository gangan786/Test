package com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/13 12:22
 * @UpdateUser:
 * @UpdateDate: 2019/1/13 12:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConcreteClassB extends AbstractClass {
    @Override
    public void diffOperation1() {
        System.out.println(this.getClass().getName() + "不同于公共代码逻辑的逻辑1执行");
    }

    @Override
    public void diffOperation2() {
        System.out.println(this.getClass().getName() + "不同于公共代码逻辑的逻辑2执行");
    }
}
