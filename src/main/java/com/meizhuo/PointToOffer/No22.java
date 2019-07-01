package com.meizhuo.PointToOffer;

import lombok.Data;
import org.junit.Test;

/**
 * @Classname No22
 * @Description 找出链表中倒数第k个节点
 * @Date 2019/7/1 12:26
 * @Created by Gangan
 */
public class No22 {


    public LinkNode findKthToTail(LinkNode headNode, int k) {
        if (k <= 0 || headNode == null) {
            throw new IllegalArgumentException("参数非法");
        }

        LinkNode aheadIndex = headNode;
        LinkNode targetIndex = null;
        for (int i = 0; i < k - 1; i++) {
            if (aheadIndex.nextNode != null) {
                aheadIndex = aheadIndex.nextNode;
            } else {
                return null;
            }
        }
        targetIndex = headNode;
        while (aheadIndex.nextNode != null) {
            aheadIndex = aheadIndex.nextNode;
            targetIndex = targetIndex.nextNode;
        }

        return targetIndex;
    }


    @Data
    class LinkNode {
        public int value;
        public LinkNode nextNode;

        public LinkNode(int value, LinkNode nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    @Test
    public void test() {
        LinkNode node7 = new LinkNode(7, null);
        LinkNode node6 = new LinkNode(6, node7);
        LinkNode node5 = new LinkNode(5, node6);
        LinkNode node4 = new LinkNode(4, node5);
        LinkNode node3 = new LinkNode(3, node4);
        LinkNode node2 = new LinkNode(2, node3);
        LinkNode headNode= new LinkNode(1, node2);
        System.out.println(findKthToTail(headNode, 1));
        System.out.println(findKthToTail(headNode, 2));
        System.out.println(findKthToTail(headNode, 3));
        System.out.println(findKthToTail(headNode, 4));
        System.out.println(findKthToTail(headNode, 5));
        System.out.println(findKthToTail(headNode, 6));
        System.out.println(findKthToTail(headNode, 7));
        System.out.println(findKthToTail(headNode, 0));
    }

}

