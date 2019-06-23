package com.meizhuo.PointToOffer;

import lombok.Data;
import org.junit.Test;

import java.util.Stack;

/**
 * @Classname No6
 * @Description 从尾到头输出链表节点内容
 * @Date 2019/6/23 11:36
 * @Created by Gangan
 */
public class No6 {

    /**
     * 使用栈进行链表的反转输出
     * @param head
     */
    public void valueByStack(LinkNode head) {

        Stack<LinkNode> stack = new Stack<>();

        LinkNode currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.nextNode;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public void valueByRecursion(LinkNode curNode) {
        if (curNode.nextNode != null) {
            valueByRecursion(curNode.nextNode);
        }
            System.out.println(curNode);

    }


    class LinkNode {
        int value;
        LinkNode nextNode;

        public LinkNode(int value, LinkNode nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "value=" + value +
                    '}';
        }
    }

    @Test
    public void test() {
        LinkNode headNode = new LinkNode(0, null);
        LinkNode lastNode = headNode;
        for (int i = 1; i < 9; i++) {
            LinkNode newNode = new LinkNode(i, null);
            lastNode.nextNode = newNode;
            lastNode = newNode;
        }

        System.out.println("栈调用：");
        valueByStack(headNode);
        System.out.println("--------------------------------------------------");
        System.out.println("递归调用");
        valueByRecursion(headNode);


    }


}
