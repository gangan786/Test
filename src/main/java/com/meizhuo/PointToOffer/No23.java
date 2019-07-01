package com.meizhuo.PointToOffer;

import lombok.Data;
import org.junit.Test;

/**
 * @Classname No23
 * @Description 链表中环的入口节点
 * @Date 2019/7/1 15:00
 * @Created by Gangan
 */
public class No23 {

    @Test
    public void test() {
        LinkNode node7 = new LinkNode(7, null);
        LinkNode node6 = new LinkNode(6, node7);
        LinkNode node5 = new LinkNode(5, node6);
        LinkNode node4 = new LinkNode(4, node5);
        LinkNode node3 = new LinkNode(3, node4);
        LinkNode node2 = new LinkNode(2, node3);
        LinkNode headNode = new LinkNode(1, node2);
        node7.setNextNode(node2);
        System.out.println(entryNodeOfLoop(headNode));

    }

    /**
     * 返回入口节点
     * 这种环你无法判断哪个是尾节点
     * 遍历一旦陷入环中只能在环中循环
     * @param headNode
     * @return
     */
    public LinkNode entryNodeOfLoop(LinkNode headNode) {
        LinkNode meetingNode = findMeetingNode(headNode);
        if (meetingNode == null) {
            return null;
        }
        LinkNode temp = meetingNode;
        int countOfNodeInLoop = 1;
        while (temp.nextNode != meetingNode) {
            countOfNodeInLoop++;
            temp = temp.nextNode;
        }

        temp = headNode;
        for (int i = 0; i < countOfNodeInLoop-1; i++) {
            temp = temp.nextNode;
        }
        LinkNode afterNode = headNode;
        while (temp.nextNode != afterNode) {
            temp = temp.nextNode;
            afterNode = afterNode.nextNode;
        }

        return afterNode;

    }

    /**
     * 只是找到环中的一个节点，这个节点在环中的位置任意
     * 走的慢得索引一定会被走的快的索引追上
     * 所以一定会出现 slowNode 与 fastNode 相等的情况
     * @param headNode
     * @return
     */
    private LinkNode findMeetingNode(LinkNode headNode) {
        if (headNode == null) {
            return null;
        }
        LinkNode slowNode = headNode;
        LinkNode fastNode = headNode.nextNode;
        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) {
                return fastNode;
            }
            slowNode = slowNode.nextNode;
            fastNode = fastNode.nextNode;
            if (fastNode != null) {
                fastNode = fastNode.nextNode;
            }
        }
        return null;

    }

    @Data
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
