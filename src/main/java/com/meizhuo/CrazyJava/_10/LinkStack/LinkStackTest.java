package com.meizhuo.CrazyJava._10.LinkStack;

public class LinkStackTest {
    public static void main(String[] args) {
        LinkStack<String> linkStack = new LinkStack<>("虚伪儿子0");
        linkStack.push("虚伪儿子1");
        linkStack.push("虚伪儿子2");
        linkStack.push("虚伪儿子3");
        linkStack.push("虚伪儿子4");
        linkStack.push("虚伪儿子5");
        linkStack.push("虚伪儿子6");
        linkStack.push("虚伪儿子7");
        System.out.println(linkStack.toString());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.toString());
        System.out.println(linkStack.peek());
        linkStack.clean();
        System.out.println(linkStack.toString());
    }
}
