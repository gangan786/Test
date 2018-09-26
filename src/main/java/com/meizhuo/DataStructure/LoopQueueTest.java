package com.meizhuo.DataStructure;

import org.junit.Test;

public class LoopQueueTest {

    @Test
    public void test(){

        LoopQueue<String>loopQueue=new LoopQueue<>("虚伪儿子0",5);
        loopQueue.add("虚伪儿子1");
        loopQueue.add("虚伪儿子2");
        loopQueue.add("虚伪儿子3");
        loopQueue.add("虚伪儿子4");
//        loopQueue.add("虚伪儿子5");//队列已满异常
        System.out.println("队列长度为："+loopQueue.length());
        System.out.println(loopQueue.toString());
        loopQueue.remove();
        loopQueue.remove();
//        loopQueue.add("追加1");
//        loopQueue.add("追加1");
        System.out.println("队列长度为："+loopQueue.length());
        loopQueue.clear();
        loopQueue.remove();
        System.out.println(loopQueue.toString());

    }
}
