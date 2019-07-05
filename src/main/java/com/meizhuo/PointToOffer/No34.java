package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Classname No34
 * @Description 二叉树中和为某一值和的路径
 * @Date 2019/7/5 12:02
 * @Created by Gangan
 */
public class No34 {

    @Test
    public void test() {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);

        BinaryTreeNode node5 = new BinaryTreeNode(5, node4, node7);
        BinaryTreeNode node12 = new BinaryTreeNode(12, null, null);

        BinaryTreeNode root = new BinaryTreeNode(10, node5, node12);

        findPath(root, 22);

    }

    public void findPath(BinaryTreeNode rootNode, int expectSum) {
        if (rootNode == null) {
            throw new NullPointerException();
        }
        int curSum = 0;
        Stack<BinaryTreeNode> path = new Stack<>();
        findPath(rootNode, expectSum, curSum, path);
    }

    private void findPath(BinaryTreeNode curNode, int expectSum,
                          int curSum, Stack<BinaryTreeNode> path) {
        curSum += curNode.value;
        path.push(curNode);
        boolean isLeaf = curNode.leftNode == null && curNode.rightNode == null;
        if (isLeaf && curSum == expectSum) {
            //找到一条符合条件的路径 进行打印
            Iterator<BinaryTreeNode> iterator = path.iterator();
            while (iterator.hasNext()) {
                BinaryTreeNode node = iterator.next();
                System.out.print(node.value + " ");
            }
            System.out.println(" ");
        }

        if (curNode.leftNode != null) {
            findPath(curNode.leftNode, expectSum, curSum, path);
        }
        if (curNode.rightNode != null) {
            findPath(curNode.rightNode, expectSum, curSum, path);
        }

        //返回父节点前删除当前节点
        path.pop();
    }

}
