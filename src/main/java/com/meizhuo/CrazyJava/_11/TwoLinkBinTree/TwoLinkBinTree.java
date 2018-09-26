package com.meizhuo.CrazyJava._11.TwoLinkBinTree;

public class TwoLinkBinTree<E> {

    public static class TreeNode {
        Object data;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private TreeNode root;

    private TreeNode temp;

    public TwoLinkBinTree() {
        root = new TreeNode();
    }

    public TwoLinkBinTree(E data) {
        root = new TreeNode(data);
    }

    public TreeNode addNode(E data, TreeNode parent, boolean isLeft) {
        if (parent == null) {
            throw new RuntimeException("parent节点为null，无法添加");
        }
        if (parent.left != null && isLeft) {
            throw new RuntimeException("parent已有左节点，无法添加左节点");
        }
        if (parent.right != null && !isLeft) {
            throw new RuntimeException("parent已有右节点，无法添加右节点");
        }
        TreeNode newTreeNode = new TreeNode(data);
        if (isLeft) {
            parent.left = newTreeNode;
        } else {
            parent.right = newTreeNode;
        }
        return newTreeNode;
    }

    public boolean empty() {
        return root == null;
    }

    public TreeNode root() {
        if (empty()) {
            throw new RuntimeException("树为null，无法访问根节点");
        }
        return root;
    }

    public TreeNode parent(TreeNode node) {
        //对于二叉链表存储法，如果要访问指定节点的父节点必须遍历二叉树
        temp = node;
        return search(root());
    }

    private TreeNode search(TreeNode node) {
        TreeNode treeNode = null;
        if (node.left == temp || node.right == temp) {
            return node;
        }

        if (node.left != null && treeNode == null) {
            treeNode = search(node.left);
        }
        if (node.right != null && treeNode == null) {
            treeNode = search(node.right);
        }
        return treeNode;
    }

    public E leftChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException("parent为null，无法访问左节点");
        }
        return parent.left == null ? null : (E) parent.left.data;
    }

    public E rightChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException("parent为null，无法访问右节点");
        }
        return parent.right == null ? null : (E) parent.right.data;
    }

    public int deep() {
        return deep(root());
    }

    //这是一个递归方法：每棵子树的深度为其所有子树的最大深度+1
    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            int leftDeep = deep(node.left);
            int rightDeep = deep(node.right);
            //记录其所有左，右子树中较大的深度
            int max = leftDeep > rightDeep ? leftDeep : rightDeep;
            return max + 1;
        }
    }

}
