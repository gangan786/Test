package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

/**
 * @Classname SampleActiveObjectImpl
 * @Description TODO
 * @Date 2019/4/5 10:15
 * @Created by Gangan
 */
public class SampleActiveObjectImpl {

    public String doProcess(String arg, int i) {
        System.out.println("\"doProcess start\" = " + "doProcess start");
        try {
            // 模拟一个比较耗时的操作
            Thread.sleep(500);
        } catch (InterruptedException e) {
            ;
        }
        return arg + "-" + i;
    }

}
