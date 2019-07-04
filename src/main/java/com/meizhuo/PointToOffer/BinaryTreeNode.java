package com.meizhuo.PointToOffer;

/**
 * @Classname BinaryTreeNode
 * @Description 二叉树节点
 * @Date 2019/7/4 10:09
 * @Created by Gangan
 */
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode leftNode;

    public BinaryTreeNode rightNode;

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public BinaryTreeNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
