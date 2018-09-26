package com.meizhuo.CrazyJava._10.LoopQueue;

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<String>loopQueue=new LoopQueue<>("虚伪儿子0",5);
        loopQueue.add("虚伪儿子1");
        loopQueue.add("虚伪儿子2");
        loopQueue.add("虚伪儿子3");
        loopQueue.add("虚伪儿子4");
        System.out.println("队列长度为："+loopQueue.length());
        System.out.println(loopQueue.toString());
//        loopQueue.add("我是你爸爸");
        loopQueue.remove();
        loopQueue.remove();
//        loopQueue.add("追加1");
//        loopQueue.add("追加1");
        System.out.println("队列长度为："+loopQueue.length());
        loopQueue.clear();
        System.out.println(loopQueue.toString());
    }
}
