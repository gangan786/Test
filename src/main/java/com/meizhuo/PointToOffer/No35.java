package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No35
 * @Description 复杂链表的复制
 * @Date 2019/7/5 15:39
 * @Created by Gangan
 */
public class No35 {

    @Test
    public void test() {
        ComplexLinkNode nodeE = new ComplexLinkNode(5, null, null);
        ComplexLinkNode nodeD = new ComplexLinkNode(4, nodeE, null);
        ComplexLinkNode nodeC = new ComplexLinkNode(3, nodeD, null);
        ComplexLinkNode nodeB = new ComplexLinkNode(2, nodeC, null);
        ComplexLinkNode nodeA = new ComplexLinkNode(1, nodeB, nodeC);
        nodeB.siblingNode=nodeE;
        nodeD.siblingNode=nodeB;

        ComplexLinkNode complexLinkNode = copyComplexLink(nodeA);
    }

    public ComplexLinkNode copyComplexLink(ComplexLinkNode head) {
        cloneNode(head);
        connectSibling(head);
        return reconnectNode(head);
    }

    /**
     * 第一步
     *
     * @param headNode
     */
    public void cloneNode(ComplexLinkNode headNode) {
        ComplexLinkNode curNode = headNode;
        while (curNode != null) {
            ComplexLinkNode clone = new ComplexLinkNode();
            clone.value = curNode.value;
            clone.nextNode = curNode.nextNode;
            clone.siblingNode = null;
            curNode.nextNode = clone;
            curNode = clone.nextNode;
        }
    }

    /**
     * 第二步
     *
     * @param headNode
     */
    public void connectSibling(ComplexLinkNode headNode) {
        ComplexLinkNode curNode = headNode;
        while (curNode != null) {
            if (curNode.siblingNode != null) {
                curNode.nextNode.siblingNode = curNode.siblingNode.nextNode;
            }
            curNode = curNode.nextNode.nextNode;
        }
    }

    /**
     * 第三步
     *
     * @param headNode
     * @return
     */
    public ComplexLinkNode reconnectNode(ComplexLinkNode headNode) {
        ComplexLinkNode curNode = headNode;
        ComplexLinkNode cloneHeadNode = null;
        ComplexLinkNode cloneCurNode = null;

        /*
        为处理只有一个节点的情况
         */
        if (curNode != null) {
            cloneHeadNode = cloneCurNode = curNode.nextNode;
            curNode.nextNode = cloneCurNode.nextNode;
            curNode = curNode.nextNode;
        }

        while (curNode != null) {
            cloneCurNode.nextNode = curNode.nextNode;
            cloneCurNode = cloneCurNode.nextNode;
            curNode.nextNode = cloneCurNode.nextNode;
            curNode = curNode.nextNode;
        }

        return cloneHeadNode;
    }

    class ComplexLinkNode {
        public int value;
        public ComplexLinkNode nextNode;
        public ComplexLinkNode siblingNode;

        public ComplexLinkNode() {
        }

        public ComplexLinkNode(int value, ComplexLinkNode nextNode, ComplexLinkNode siblingNode) {
            this.value = value;
            this.nextNode = nextNode;
            this.siblingNode = siblingNode;
        }

        @Override
        public String toString() {
            return "CompliexLinkNode{" +
                    "value=" + value +
                    '}';
        }
    }


}
