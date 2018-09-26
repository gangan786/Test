package com.meizhuo.CrazyJava._9.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> sequenceList=new SequenceList<>();
        sequenceList.add("虚伪儿子0");
        sequenceList.add("虚伪儿子1");
        sequenceList.add("虚伪儿子2");
        sequenceList.add("虚伪儿子3");
        sequenceList.add("虚伪儿子4");
        sequenceList.add("虚伪儿子5");
        sequenceList.add("虚伪儿子6");
        System.out.println(sequenceList.toString());
//        sequenceList.remove();
//        sequenceList.delete(3);
//        sequenceList.insert(2,"插入2");
//        System.out.println(sequenceList.locate("我是黄虚伪的爸爸"));
//        System.out.println(sequenceList.locate("虚伪儿子6"));
//        sequenceList.clear();
        System.out.println(sequenceList.empty());
        System.out.println(sequenceList.toString());
    }
}
