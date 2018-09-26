package com.meizhuo.CrazyJava._9.DulLinkList;

public class DulLinkListTest {
    public static void main(String[] args) {
        DulLinkList<String> dulLinkList = new DulLinkList<>();
//        dulLinkList.add("虚伪儿子0");
//        dulLinkList.add("虚伪儿子1");
//        dulLinkList.add("虚伪儿子2");
//        dulLinkList.add("虚伪儿子3");
//        dulLinkList.add("虚伪儿子4");
//        dulLinkList.add("虚伪儿子5");
//        dulLinkList.add("虚伪儿子6");
//        dulLinkList.add("虚伪儿子7");

        dulLinkList.addAtHeader("虚伪儿子0");
        dulLinkList.addAtHeader("虚伪儿子1");
        dulLinkList.addAtHeader("虚伪儿子2");
        dulLinkList.addAtHeader("虚伪儿子3");
        dulLinkList.addAtHeader("虚伪儿子4");
        dulLinkList.addAtHeader("虚伪儿子5");
        dulLinkList.addAtHeader("虚伪儿子6");
        dulLinkList.addAtHeader("虚伪儿子7");
//        dulLinkList.delete(1);
        dulLinkList.insert("陈淦是你爸爸", 8);
//        dulLinkList.remove();
        System.out.println(dulLinkList.get(7));
        System.out.println(dulLinkList.get(1));
        System.out.println(dulLinkList.locate("陈淦是你爸爸"));

        System.out.println(dulLinkList.toString());
        dulLinkList.clear();
        System.out.println(dulLinkList.reverseToString());
    }
}
