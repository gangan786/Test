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

        sumTree(node);

    }

    private static void sumTree(BinaryNode node) {
        if (node == null) {
            return;
        }
        sumTree(node.leftNode);
        sumTree(node.rightNode);

    }

    private static BinaryNode buildTree(int[] preOrder, int preStartIndex, int preEndIndex,
                                        int[] inOrder, int inStartIndex, int inEndIndex) {
        //前序遍历的第一个节点为根节点
        int rootValue = preOrder[preStartIndex];
        BinaryNode node = new BinaryNode();
        node.value=rootValue;

        if (preStartIndex == preEndIndex) {
            if (inStartIndex == inEndIndex && preOrder[preStartIndex] == inOrder[inStartIndex]) {
                return node;
            } else {
                return null;
            }
        }

        //在中序遍历中找到根节点的值
        int rootInOrderIndex=inStartIndex;
        while (rootInOrderIndex <= inEndIndex && inOrder[rootInOrderIndex] != rootValue) {
            rootInOrderIndex++;
        }

        int leftLength=rootInOrderIndex-inStartIndex;
        int leftpreOrderEnd=preStartIndex+leftLength;
        if (leftLength > 0) {
            //构建左子树
            node.leftNode=buildTree(preOrder, preStartIndex+1, leftpreOrderEnd,
                    inOrder, inStartIndex, rootInOrderIndex-1);
        }
        if (leftLength < preEndIndex - preStartIndex) {
            //构建右子树
            node.rightNode=buildTree(preOrder, leftpreOrderEnd+1, preEndIndex,
                    inOrder, rootInOrderIndex+1, inEndIndex);
        }

        return node;
    }

}
