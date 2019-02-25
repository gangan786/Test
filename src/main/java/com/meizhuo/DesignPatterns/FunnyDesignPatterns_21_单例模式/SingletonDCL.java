package com.meizhuo.DesignPatterns.FunnyDesignPatterns_21_单例模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_21_单例模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/25 11:06
 * @UpdateUser:
 * @UpdateDate: 2019/2/25 11:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class SingletonDCL {

    private SingletonDCL() {

    }

    private volatile static SingletonDCL instance = null;

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }

}
