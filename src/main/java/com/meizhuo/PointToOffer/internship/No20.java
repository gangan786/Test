package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No20
 * @Description 重建二叉树 求和
 * @Date 2019/8/22 13:57
 * @Created by Gangan
 */
public class No20 {

    static class BinaryNode {
        public int value;
        public int sum;
        public BinaryNode leftNode;
        public BinaryNode rightNode;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String[] c = a.split(" ");
        String[] d = b.split(" ");
        int[] preOrder = new int[c.length];
        int[] inOrder = new int[d.length];
        for (int i = 0; i < preOrder.length; i++) {
            preOrder[i] = Integer.valueOf(c[i]);
            inOrder[i] = Integer.valueOf(d[i]);
        }

        //构建树
        BinaryNode node = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);

        //构建求和树
        sumTree(node);

        //中序遍历输出
        printInOrder(node);

    }

    private static void printInOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.leftNode);
        System.out.print(node.sum+" ");
        printInOrder(node.rightNode);
    }

    private static void sumTree(BinaryNode node) {
        if (node == null) {
            return;
        }
        sumTree(node.leftNode);
        sumTree(node.rightNode);
        if (node.leftNode != null) {
            node.sum += node.leftNode.value + node.leftNode.sum;
        }
        if (node.rightNode != null) {
            node.sum += node.rightNode.value + node.rightNode.sum;
        }
        //判断是否为叶子节点
        if (node.leftNode != null && node.leftNode.leftNode == null && node.leftNode.rightNode == null) {
            node.leftNode.value = 0;
        }
        if (node.rightNode != null && node.rightNode.leftNode == null && node.rightNode.rightNode == null) {
            node.rightNode.value = 0;
        }

    }

    private static BinaryNode buildTree(int[] preOrder, int preStartIndex, int preEndIndex,
                                        int[] inOrder, int inStartIndex, int inEndIndex) {
        //前序遍历的第一个节点为根节点
        int rootValue = preOrder[preStartIndex];
        BinaryNode node = new BinaryNode();
        node.value = rootValue;

        if (preStartIndex == preEndIndex) {
            if (inStartIndex == inEndIndex && preOrder[preStartIndex] == inOrder[inStartIndex]) {
                return node;
            } else {
                return null;
            }
        }

        //在中序遍历中找到根节点的值
        int rootInOrderIndex = inStartIndex;
        while (rootInOrderIndex <= inEndIndex && inOrder[rootInOrderIndex] != rootValue) {
            rootInOrderIndex++;
        }

        int leftLength = rootInOrderIndex - inStartIndex;
        int leftPreOrderEnd = preStartIndex + leftLength;
        if (leftLength > 0) {
            //构建左子树
            node.leftNode = buildTree(preOrder, preStartIndex + 1, leftPreOrderEnd,
                    inOrder, inStartIndex, rootInOrderIndex - 1);
        }
        if (leftLength < preEndIndex - preStartIndex) {
            //构建右子树
            node.rightNode = buildTree(preOrder, leftPreOrderEnd + 1, preEndIndex,
                    inOrder, rootInOrderIndex + 1, inEndIndex);
        }

        return node;
    }

}
