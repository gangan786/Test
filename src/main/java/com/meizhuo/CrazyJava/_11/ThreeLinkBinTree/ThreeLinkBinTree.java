package com.meizhuo.CrazyJava._11.ThreeLinkBinTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ThreeLinkBinTree<E> {

    public static class TreeNode {
        private Object data;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

    }

    private TreeNode root;

    public ThreeLinkBinTree(E data) {
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
        newTreeNode.parent = parent;
        return newTreeNode;
    }

    public boolean empty() {
        return root == null;
    }

    public TreeNode root() {
        if (empty()) {
            throw new RuntimeException("树为空，无法访问根节点");
        }
        return root;
    }

    public E parent(TreeNode node) {
        if (node == null) {
            throw new RuntimeException(node + "节点为空，无法访问其父节点");
        }
        return (E) node.parent.data;
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

    public List<E> preIterator() {
        return preIterator(root());
    }

    /**
     * 前序遍历
     *
     * @param node
     * @return 遍历数组
     */
    private List<E> preIterator(TreeNode node) {
        List<E> treeNodes = new ArrayList<>();
        treeNodes.add((E) node.data);
        if (node.left != null) {
            treeNodes.addAll(preIterator(node.left));
        }
        if (node.right != null) {
            treeNodes.addAll(preIterator(node.right));
        }
        return treeNodes;
    }

    public List<E> inIterator() {
        return inIterator(root());
    }

    /**
     * 中序遍历
     *
     * @param node
     * @return 遍历数组
     */
    private List<E> inIterator(TreeNode node) {
        List<E> treeNodes = new ArrayList<>();
        if (node.left != null) {
            treeNodes.addAll(preIterator(node.left));
        }
        treeNodes.add((E) node.data);
        if (node.right != null) {
            treeNodes.addAll(preIterator(node.right));
        }
        return treeNodes;
    }

    public List<E> postIterator() {
        return postIterator(root());
    }

    /**
     * 后续遍历
     *
     * @param node
     * @return 返回遍历数组
     */
    private List<E> postIterator(TreeNode node) {
        List<E> treeNodes = new ArrayList<>();
        if (node.left != null) {
            treeNodes.addAll(preIterator(node.left));
        }
        if (node.right != null) {
            treeNodes.addAll(preIterator(node.right));
        }
        treeNodes.add((E) node.data);
        return treeNodes;
    }

    public List<E> breadthFirst() {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<E> list = new ArrayList<>();
        if (!empty()) {
            //将根元素加入队列
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            //将该队列的队尾元素添加到List中
            list.add((E) queue.peek().data);
            TreeNode p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return list;
    }

}



















