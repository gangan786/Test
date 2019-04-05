package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Classname SampleClientOfReusableActiveObject
 * @Description TODO
 * @Date 2019/4/5 10:19
 * @Created by Gangan
 */
public class SampleClientOfReusableActiveObject {

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {

        SampleActiveObject sao = ActiveObjectProxy.newInstance(
                SampleActiveObject.class, new SampleActiveObjectImpl(),
                Executors.newCachedThreadPool());
        Future<String> ft = null;

        System.out.println("Before calling active object");
        try {
            ft = sao.process("Something", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 模拟其他操作的时间消耗
        Thread.sleep(40);
        System.out.println("开始运行");

        System.out.println(ft.get());
        System.out.println("结束运行");
    }

}
