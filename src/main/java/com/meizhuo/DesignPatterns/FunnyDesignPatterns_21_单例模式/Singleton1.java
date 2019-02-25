package com.meizhuo.DesignPatterns.FunnyDesignPatterns_21_单例模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_21_单例模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/25 10:14
 * @UpdateUser:
 * @UpdateDate: 2019/2/25 10:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Singleton1 {

    public static void main(String[] args) {
        Singleton1 instance = getInstance();
        System.out.println(instance);
    }

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        /**
         * 单例
         */
        INSTANCE;

        private Singleton1 singleton1;

        Singleton() {
            singleton1 = new Singleton1();
        }

        public Singleton1 getInstance() {
            return singleton1;
        }
    }

    public void test() {

    }

    protected void test(int y){

    }

}
