package com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/13 12:17
 * @UpdateUser:
 * @UpdateDate: 2019/1/13 12:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class AbstractClass {

    /**
     * 不同于公共代码的处理逻辑1
     */
    public abstract void diffOperation1();

    /**
     * 不同于公共代码的处理逻辑2
     */
    public abstract void diffOperation2();

    public void normalOperation() {
        diffOperation1();
        diffOperation2();
        System.out.println("公共代码处理逻辑执行。。。");
    }

}
