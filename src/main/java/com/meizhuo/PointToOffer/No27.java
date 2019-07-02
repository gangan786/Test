package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No27
 * @Description 将二叉树改造为他的镜像
 * @Date 2019/7/2 15:52
 * @Created by Gangan
 */
public class No27 {

    @Test
    public void test() {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(2, node6, node7);
        BinaryTreeNode node4 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(8, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(8, node2, node3);

        mirrorRecursively(node1);
    }

    public void mirrorRecursively(BinaryTreeNode head) {
        if (head.leftNode == null && head.rightNode == null) {
            return;
        }
        BinaryTreeNode temp=head.leftNode;
        head.leftNode=head.rightNode;
        head.rightNode=temp;
        if (head.rightNode != null) {
            mirrorRecursively(head.rightNode);
        }
        if (head.leftNode != null) {
            mirrorRecursively(head.leftNode);
        }
    }

    class BinaryTreeNode{
        public int value;
        public BinaryTreeNode leftNode;
        public BinaryTreeNode rightNode;

        public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    '}';
        }
    }

}
