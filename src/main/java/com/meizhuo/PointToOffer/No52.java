package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No52
 * @Description 两个链表的第一个公共节点
 * @Date 2019/7/22 10:52
 * @Created by Gangan
 */
public class No52 {

    @Test
    public void test() {
        LinkNode<Integer> node7 = new LinkNode<Integer>(7, null);
        LinkNode<Integer> node6 = new LinkNode<Integer>(6, node7);
        LinkNode<Integer> node5 = new LinkNode<Integer>(5, node6);
        LinkNode<Integer> node4 = new LinkNode<Integer>(4, node5);
        LinkNode<Integer> node3 = new LinkNode<Integer>(3, node6);
        LinkNode<Integer> node2 = new LinkNode<Integer>(2, node3);
        LinkNode<Integer> node1 = new LinkNode<Integer>(1, node2);

        System.out.println(findFirstCommonNode(node1, node4));
    }

    public LinkNode findFirstCommonNode(LinkNode headA, LinkNode headB) {
        if (headA == null || headB == null) {
            throw new NullPointerException();
        }

        //计算两个链表的长度
        int linkALength = linkLength(headA);
        int linkBLength = linkLength(headB);
        int diffNodeIndex = linkALength - linkBLength;

        LinkNode curLongNode = headA;
        LinkNode curShortNode = headB;

        if (diffNodeIndex < 0) {
            diffNodeIndex = linkBLength - linkALength;
            curLongNode = headB;
            curShortNode = headA;
        }

        //长的先行diffNodeIndex步
        for (int i = 0; i < diffNodeIndex; i++) {
            curLongNode = curLongNode.nextNode;
        }

        while (curShortNode != null &&
                curLongNode != null &&
                !curLongNode.equals(curShortNode)) {
            curLongNode = curLongNode.nextNode;
            curShortNode = curShortNode.nextNode;
        }

        if (curLongNode != null) {
            return curLongNode;
        } else {
            return null;
        }
    }

    private int linkLength(LinkNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.nextNode;
        }
        return count;
    }

}
