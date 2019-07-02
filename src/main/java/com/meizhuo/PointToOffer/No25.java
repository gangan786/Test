package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No25
 * @Description 合并两个排序的链表
 * @Date 2019/7/2 12:14
 * @Created by Gangan
 */
public class No25 {

    @Test
    public void test() {
        LinkNode node7 = new LinkNode(7, null);
        LinkNode node5 = new LinkNode(5, node7);
        LinkNode node3 = new LinkNode(3, node5);
        LinkNode head1 = new LinkNode(1, node3);


        LinkNode node6 = new LinkNode(6, null);
        LinkNode node4 = new LinkNode(4, node6);
        LinkNode head2 = new LinkNode(2, node4);

        LinkNode linkNode = mergeTwoLink(head1, head2);
    }

    public LinkNode mergeTwoLink(LinkNode head1, LinkNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        LinkNode newNode = null;
        if (head1.value >= head2.value) {
            newNode = head2;
            newNode.nextNode = mergeTwoLink(head1, head2.nextNode);
        } else {
            newNode = head1;
            newNode.nextNode = mergeTwoLink(head1.nextNode, head2);
        }
        return newNode;
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
