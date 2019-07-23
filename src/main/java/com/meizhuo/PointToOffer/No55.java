package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No55
 * @Description 二叉树的深度
 * @Date 2019/7/23 13:58
 * @Created by Gangan
 */
public class No55 {

    @Test
    public void test() {
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node6, node8);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node2, node4);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node3, node7);
        System.out.println(depthOfTree(node5));
    }

    public int depthOfTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depthOfTree(root.leftNode);
        int rightDepth = depthOfTree(root.rightNode);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    @Test
    public void testIsBalance() {
        BinaryTreeNode n8 = new BinaryTreeNode(8,null,null);
        BinaryTreeNode n7 = new BinaryTreeNode(7,n8,null);
        BinaryTreeNode n6 = new BinaryTreeNode(6,null,null);
        BinaryTreeNode n5 = new BinaryTreeNode(5,n7,null);
        BinaryTreeNode n4 = new BinaryTreeNode(4,null,null);
        BinaryTreeNode n3 = new BinaryTreeNode(3,null,n6);
        BinaryTreeNode n2 = new BinaryTreeNode(2,n4,n5);
        BinaryTreeNode n1 = new BinaryTreeNode(1,n2,n3);
        System.out.println(isBalance(n1));
    }

    /**
     * 若是个平衡二叉树则返回大于0的数
     * 否则返回-1
     * @param root
     * @return 返回值表示树的深度
     */
    public int isBalance(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        left = isBalance(root.leftNode);
        if (left != -1) {
            //如果左子树不是平衡树了，那么右子树就没有计算的必要了直接返回
            right = isBalance(root.rightNode);
        }
        if (left != -1 && right != -1) {
            int diff = Math.abs(left - right);
            if (diff <= 1) {
                return (left < right ? right : left) + 1;
            }
        }
        return -1;
    }

}
