package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No36
 * @Description 二叉搜索树转换为双向链表
 * @Date 2019/7/6 17:49
 * @Created by Gangan
 */
public class No36 {

    @Test
    public void test() {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node12 = new BinaryTreeNode(12, null, null);
        BinaryTreeNode node16 = new BinaryTreeNode(16, null, null);

        BinaryTreeNode node6 = new BinaryTreeNode(6, node4, node8);
        BinaryTreeNode node14 = new BinaryTreeNode(14, node12, node16);
        BinaryTreeNode root = new BinaryTreeNode(10, node6, node14);

        BinaryTreeNode convert = convert(root);
    }


    public BinaryTreeNode convert(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            throw new NullPointerException();
        }

        ShareBinaryTreeNode shareNode = new ShareBinaryTreeNode();
        convert(rootNode, shareNode);
        BinaryTreeNode headNode = shareNode.lastNode;
        while (headNode != null && headNode.leftNode != null) {
            headNode = headNode.leftNode;
        }
        return headNode;
    }

    private void convert(BinaryTreeNode curNode, ShareBinaryTreeNode shareNode) {
        if (curNode == null) {
            throw new NullPointerException();
        }

        if (curNode.leftNode != null) {
            convert(curNode.leftNode, shareNode);
        }

        curNode.leftNode = shareNode.lastNode;
        if (shareNode.lastNode != null) {
            shareNode.lastNode.rightNode = curNode;
        }
        shareNode.lastNode = curNode;

        if (curNode.rightNode != null) {
            convert(curNode.rightNode, shareNode);
        }

    }

    class ShareBinaryTreeNode {
        public BinaryTreeNode lastNode;
    }

}
