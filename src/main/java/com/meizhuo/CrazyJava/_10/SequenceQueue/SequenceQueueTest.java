package com.meizhuo.CrazyJava._10.SequenceQueue;

public class SequenceQueueTest {
    public static void main(String[] args) {
        SequenceQueue<String> sequenceQueue = new SequenceQueue<>("虚伪儿子0", 3);
//        sequenceQueue.add("虚伪儿子1");
//        sequenceQueue.add("虚伪儿子2");
//        sequenceQueue.add("虚伪儿子3");
//        sequenceQueue.add("虚伪儿子4");
//        sequenceQueue.add("虚伪儿子5");
//        System.out.println(sequenceQueue.toString());
////        sequenceQueue.add("虚伪儿子6");
//        System.out.println("队列长度为："+sequenceQueue.length());
//        sequenceQueue.remove();
//        System.out.println("队列长度为："+sequenceQueue.length());
//        System.out.println(sequenceQueue.toString());
//        sequenceQueue.remove();
//        System.out.println("队列长度为："+sequenceQueue.length());
//        System.out.println(sequenceQueue.toString());
//        System.out.println(sequenceQueue.element());
//        sequenceQueue.clear();
//        System.out.println("队列长度为："+sequenceQueue.length());

        sequenceQueue.add("虚伪儿子1");
        sequenceQueue.add("虚伪儿子2");
        sequenceQueue.remove();
        sequenceQueue.remove();
        sequenceQueue.remove();
        sequenceQueue.add("我是你爸");
        System.out.println(sequenceQueue.toString());

    }
}
