package com.meizhuo.CrazyJava._9.LinkList;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> linkList=new LinkList<String>();
        linkList.add("虚伪儿子0");
        linkList.add("虚伪儿子1");
        linkList.add("虚伪儿子2");
        linkList.add("虚伪儿子3");
        linkList.add("虚伪儿子4");
        linkList.add("虚伪儿子5");
        linkList.add("虚伪儿子6");
//        linkList.delete(0);
//        linkList.insert(3,"陈淦是你爸爸");
        System.out.println(linkList.locate("虚伪儿子2"));
        linkList.remove();
        System.out.println(linkList.toString());
        linkList.clean();
        System.out.println(linkList.toString());
    }
}
