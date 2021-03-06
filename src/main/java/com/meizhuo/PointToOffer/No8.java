package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No8
 * @Description 获取二叉树指定节点的下一个节点
 * @Date 2019/6/24 14:29
 * @Created by Gangan
 */
public class No8 {

    /**
     * 依据中序遍历获取指定节点的下一个节点
     *
     * @param node
     * @return
     */
    public BinaryTreeNode nextNodeInMidOrder(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode nextNode = null;
        BinaryTreeNode tempNode = null;

        if (node.rightNode != null) {
            tempNode = node.rightNode;
            while (tempNode.leftNode != null) {
                tempNode = tempNode.leftNode;
            }
            nextNode = tempNode;
        } else if (node.parentNode != null) {
            BinaryTreeNode curNode = node;
            BinaryTreeNode parNode = node.parentNode;
            while (parNode != null && parNode.rightNode.equals(curNode)) {
                curNode = parNode;
                parNode = curNode.parentNode;
            }
            nextNode = curNode.parentNode;
        }

        return nextNode;

    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    public BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }

        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        // 取前序遍历的第一个数字，就是当前的根结点
        int value = preorder[ps];
        int index = is;
        // 在中序遍历的数组中找根结点的位置
        while (index <= ie && inorder[index] != value) {
            index++;
        }

        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        // 创建当前的根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.leftNode = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.rightNode = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

        if (node.leftNode != null) {
            node.leftNode.parentNode = node;
        }
        if (node.rightNode != null) {
            node.rightNode.parentNode = node;
        }

        // 返回创建的根结点
        return node;
    }

    public class BinaryTreeNode {
        int value;
        public BinaryTreeNode parentNode;
        public BinaryTreeNode leftNode;
        public BinaryTreeNode rightNode;

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof BinaryTreeNode) {
                BinaryTreeNode node = (BinaryTreeNode) obj;
                if (node.value == this.value) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }


    @Test
    public void test() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        //构建二叉树
        BinaryTreeNode root = construct(preorder, inorder);
        System.out.println("根节点的下一个节点为：" + nextNodeInMidOrder(root));
    }
}

