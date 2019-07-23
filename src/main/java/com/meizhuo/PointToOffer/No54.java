package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No54
 * @Description 二叉搜索树的第K大节点
 * @Date 2019/7/23 11:21
 * @Created by Gangan
 */
public class No54 {

    @Test
    public void test() {
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node6, node8);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node2, node4);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node3, node7);
        System.out.println(kthNode(node5, 1));

    }


    public BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        this.k = k;
        if (root == null || k == 0) {
            return null;
        }
        return kthNodeCode(root);
    }

    private int k = 0;

    private BinaryTreeNode kthNodeCode(BinaryTreeNode root) {
        BinaryTreeNode target = null;
        if (root.leftNode != null) {
            target = kthNodeCode(root.leftNode);
        }
        if (target == null) {
            if (this.k == 1) {
                target = root;
            } else {
                this.k--;
            }
        }
        if (target == null && root.rightNode != null) {
            target = kthNodeCode(root.rightNode);
        }
        return target;
    }

}
