package com.meizhuo.PointToOffer;

/**
 * @Classname No28
 * @Description 判断一个二叉树是否关于根节点对称
 * @Date 2019/7/2 16:23
 * @Created by Gangan
 */
public class No28 {

    public boolean isSymmetrical(BinaryTreeNode rootA, BinaryTreeNode rootB) {
        if (rootA == null && rootB == null) {
            return true;
        }
        if (rootA == null || rootB == null) {
            return false;
        }
        if (rootA.value != rootB.value) {
            return false;
        }
        return isSymmetrical(rootA.leftNode, rootB.rightNode) &&
                isSymmetrical(rootA.rightNode, rootB.leftNode);
    }

    class BinaryTreeNode {
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
