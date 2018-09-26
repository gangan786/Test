package com.meizhuo.CrazyJava._10.SequenceStack;

public class SequenceStackTest {
    public static void main(String[] args) {
        SequenceStack<String> sequenceStack = new SequenceStack<>("虚伪儿子0", 2, 4);
        sequenceStack.push("虚伪儿子1");
        sequenceStack.push("虚伪儿子2");
        sequenceStack.push("虚伪儿子3");
        sequenceStack.push("虚伪儿子4");
        sequenceStack.push("虚伪儿子5");
        sequenceStack.push("虚伪儿子6");
        System.out.println(sequenceStack.toString());
        sequenceStack.pop();
        System.out.println(sequenceStack.toString());
        System.out.println(sequenceStack.peek());
        sequenceStack.clean();
        System.out.println(sequenceStack.toString());
    }
}
