package com.meizhuo.PointToOffer;


import java.util.ArrayList;
/**
 * @Classname No32
 * @Description 层序遍历二叉树
 * @Date 2019/7/4 10:07
 * @Created by Gangan
 */
public class No32 {

    public void printFromTopToBottom(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            throw new NullPointerException();
        }
        ArrayList<BinaryTreeNode> nodeQueue = new ArrayList<>();
        nodeQueue.add(rootNode);
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode curNode = nodeQueue.get(0);
            System.out.println(curNode);
            if (curNode.leftNode != null) {
                nodeQueue.add(nodeQueue.size()-1,curNode.leftNode);
            }
            if (curNode.rightNode != null) {
                nodeQueue.add(nodeQueue.size()-1,curNode.rightNode);
            }
        }
    }

    public void test() {
        printFromTopToBottom(null);
    }

}
