package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No26
 * @Description 树的子结构
 * @Date 2019/7/2 14:37
 * @Created by Gangan
 */
public class No26 {

    @Test
    public void test() {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(2, node6, node7);
        BinaryTreeNode node4 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(8, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(8, node2, node3);


        BinaryTreeNode node10 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, node9, node10);

        System.out.println(hasSubTree(node1, node8));

    }

    /**
     * 判断是否为子树
     *
     * @param masterRootNode 大的主树
     * @param childRootNode  可能为子树
     * @return
     */
    public boolean hasSubTree(BinaryTreeNode masterRootNode, BinaryTreeNode childRootNode) {
        boolean isChildTree = false;
        if (masterRootNode != null && childRootNode != null) {
            if (compare2Double(masterRootNode.value, childRootNode.value)) {
                isChildTree = doesMasterTreeHaveChildTree(masterRootNode, childRootNode);
            }

            if (!isChildTree) {
                isChildTree = hasSubTree(masterRootNode.leftNode, childRootNode);
            }
            if (!isChildTree) {
                isChildTree = hasSubTree(masterRootNode.rightNode, childRootNode);
            }
        }
        return isChildTree;

    }

    private boolean doesMasterTreeHaveChildTree(BinaryTreeNode masterRootNode,
                                                BinaryTreeNode childRootNode) {
        if (childRootNode == null) {
            return true;
        }
        if (masterRootNode == null) {
            return false;
        }
        if (!compare2Double(masterRootNode.value, childRootNode.value)) {
            return false;
        }
        return doesMasterTreeHaveChildTree(masterRootNode.leftNode, childRootNode.leftNode) &&
                doesMasterTreeHaveChildTree(masterRootNode.rightNode, childRootNode.rightNode);


    }

    private boolean compare2Double(double a, double b) {
        double accuracy = 0.000001;
        if (Math.abs(a - b) < accuracy) {
            return true;
        } else {
            return false;
        }
    }


    class BinaryTreeNode {
        public double value;
        public BinaryTreeNode leftNode;
        public BinaryTreeNode rightNode;

        public BinaryTreeNode(double value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
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
