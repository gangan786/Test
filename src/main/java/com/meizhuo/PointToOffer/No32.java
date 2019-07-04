package com.meizhuo.PointToOffer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname No32
 * @Description 层序遍历二叉树
 * @Date 2019/7/4 10:07
 * @Created by Gangan
 */
public class No32 {

    @Test
    public void test() {
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node11 = new BinaryTreeNode(11, null, null);
        BinaryTreeNode node12 = new BinaryTreeNode(12, null, null);
        BinaryTreeNode node13 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node14 = new BinaryTreeNode(14, null, null);
        BinaryTreeNode node15 = new BinaryTreeNode(15, null, null);

        BinaryTreeNode node4 = new BinaryTreeNode(4, node8,node9);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node10, node11);
        BinaryTreeNode node6 = new BinaryTreeNode(6, node12, node13);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node14, node15);

        BinaryTreeNode node2 = new BinaryTreeNode(2,node4,node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);

        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        //printFromTopToBottom(root);
        print(root);
        printLikeSnake(root);
    }


    public void printFromTopToBottom(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            throw new NullPointerException();
        }
        ArrayList<BinaryTreeNode> nodeQueue = new ArrayList<>();
        nodeQueue.add(rootNode);
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode curNode = nodeQueue.remove(0);
            System.out.print(curNode.value+" ");
            if (curNode.leftNode != null) {
                nodeQueue.add(curNode.leftNode);
            }
            if (curNode.rightNode != null) {
                nodeQueue.add(curNode.rightNode);
            }
        }
    }


    public void print(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            throw new NullPointerException();
        }
        int countPrint=1;
        int nextLinePrint=0;
        ArrayList<BinaryTreeNode> nodeQueue = new ArrayList<>();
        nodeQueue.add(rootNode);
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode curNode = nodeQueue.remove(0);
            System.out.print(curNode.value+" ");
            if (curNode.leftNode != null) {
                nodeQueue.add(curNode.leftNode);
                nextLinePrint++;
            }
            if (curNode.rightNode != null) {
                nodeQueue.add( curNode.rightNode);
                nextLinePrint++;
            }
            countPrint--;
            if (countPrint == 0) {
                System.out.print("\n");
                countPrint=nextLinePrint;
                nextLinePrint=0;
            }
        }
    }

    public void printLikeSnake(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            throw new NullPointerException();
        }

        int tire=1;
        Stack<BinaryTreeNode> oddStack = new Stack<>();
        Stack<BinaryTreeNode> evenStack = new Stack<>();
        oddStack.push(rootNode);
        while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
            if (tire == 1) {
                //这里是单层
                BinaryTreeNode oddNode = oddStack.pop();
                System.out.print(oddNode.value+" ");
                if (oddNode.leftNode != null) {
                    evenStack.push(oddNode.leftNode);
                }
                if (oddNode.rightNode != null) {
                    evenStack.push(oddNode.rightNode);
                }
                if (oddStack.isEmpty()) {
                    tire=0;
                    System.out.print("\n");
                }
            } else if (tire == 0) {
                //这里是双层
                BinaryTreeNode evenNode = evenStack.pop();
                System.out.print(evenNode.value+" ");
                if (evenNode.rightNode != null) {
                    oddStack.push(evenNode.rightNode);
                }
                if (evenNode.leftNode != null) {
                    oddStack.push(evenNode.leftNode);
                }
                if (evenStack.isEmpty()) {
                    tire=1;
                    System.out.print("\n");
                }
            }
        }
    }

}
