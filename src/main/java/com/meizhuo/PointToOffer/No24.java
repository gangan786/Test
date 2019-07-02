package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No24
 * @Description 反转列表
 * @Date 2019/7/2 10:20
 * @Created by Gangan
 */
public class No24 {

    @Test
    public void test() {
        LinkNode node7 = new LinkNode(7, null);
        LinkNode node6 = new LinkNode(6, node7);
        LinkNode node5 = new LinkNode(5, node6);
        LinkNode node4 = new LinkNode(4, node5);
        LinkNode node3 = new LinkNode(3, node4);
        LinkNode node2 = new LinkNode(2, node3);
        LinkNode headNode = new LinkNode(1, node2);
        System.out.println(reverseListByRecursion(headNode));
    }

    /**
     * 非递归实现反转链表
     * @param headNode
     * @return
     */
    public LinkNode reverseList(LinkNode headNode) {
        LinkNode preNode = null;
        LinkNode curNode = headNode;
        LinkNode nextNode = null;

        LinkNode reverseNode = null;

        while (curNode != null) {
            nextNode = curNode.nextNode;
            if (nextNode == null) {
                reverseNode = curNode;
            }
            curNode.nextNode = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return reverseNode;
    }

    /**
     * 递归实现反转链表
     * @param headNode
     * @return
     */
    public LinkNode reverseListByRecursion(LinkNode headNode) {
        if (headNode == null || headNode.nextNode == null) {
            return headNode;
        }
        LinkNode pre = reverseListByRecursion(headNode.nextNode);
        headNode.nextNode.nextNode = headNode;
        headNode.nextNode=null;
        return pre;
    }


    class LinkNode {
        public int value;
        public LinkNode nextNode;

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


}
