package com.meizhuo.CrazyJava._10.LinkQueue;

import org.junit.Test;

public class LinkQueueTest {
    @Test
    public void test(){
        LinkQueue<String> linkQueue=new LinkQueue<>("虚伪儿子0");
        linkQueue.add("虚伪儿子1");
        linkQueue.add("虚伪儿子2");
        linkQueue.add("虚伪儿子3");
        linkQueue.add("虚伪儿子4");
        linkQueue.add("虚伪儿子5");
        linkQueue.add("虚伪儿子6");
        System.out.println(linkQueue.toString());
        System.out.println("链队列的长度为："+linkQueue.size());
        linkQueue.remove();
        linkQueue.remove();
        System.out.println(linkQueue.toString());
        System.out.println("链队列的长度为："+linkQueue.size());
        System.out.println(linkQueue.element());
    }
}
