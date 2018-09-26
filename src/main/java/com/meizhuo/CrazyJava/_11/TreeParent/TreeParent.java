package com.meizhuo.CrazyJava._11.TreeParent;

import java.util.ArrayList;
import java.util.List;

public class TreeParent<T> {

    public static class Node<T> {

        T data;
        private int parent;//记录父节点

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, int parent) {
            this.data = data;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "TreeParent$Node[data=" + data + ", parent=" + parent + "]";
        }
    }

    private int DEFAULT_TREE_SIZE = 100;//默认长度
    private int treeSize;//树长度
    private Node<T> nodes[];//使用一个数组来保存树里面的所有节点
    private int nodeNums;//记录节点数

    public TreeParent(T data) {
        //以指定节点创建树
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<T>(data, -1);
        nodeNums++;
    }

    public TreeParent(T data, int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[this.treeSize];
        nodes[0] = new Node<T>(data, -1);
        nodeNums++;
    }

    /**
     * 为指定节点添加子节点
     * 返回添加的那个节点
     *
     * @param data
     * @param parent
     * @return
     */
    public Node addNode(T data, Node parent) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node<T>(data, pos(parent));
                nodeNums++;
                return nodes[i];
            }
        }
        throw new RuntimeException("该树已满，无法添加新节点");
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean empty() {
        return nodes[0] == null;
    }

    /**
     * 返回根节点
     *
     * @return
     */
    public Node<T> root() {
        return nodes[0];
    }

    /**
     * 返回指定节点的（非根节点）的父节点
     *
     * @param node
     * @return
     */
    public Node<T> parent(Node node) {
        if (node == root()) {
            throw new RuntimeException(node.toString() + "为根节点");
        }
        return nodes[node.parent];
    }

    /**
     * 返回指定节点（非叶子节点）的所有子节点
     *
     * @param parent
     * @return
     */
    public List<Node<T>> children(Node parent) {
        List<Node<T>> list = new ArrayList<Node<T>>();
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null && nodes[i].parent == pos(parent)) {
                list.add(nodes[i]);
            }
        }
        return list;
    }

    /**
     * 返回树的深度
     *
     * @return
     */
    public int deep() {
        //用于记录节点的最大深度
        int max = 0;
        for (int i = 0; i < treeSize && nodes[i] != null; i++) {
            int def = 1;//初始化本节点的深度
            int m = nodes[i].parent;//记录当前节点
            while (m != -1 && nodes[m] != null) {//满足条件说明还有父节点，那就一直往上找一直找到父节点
                m = nodes[m].parent;
                def++;
            }
            if (max < def) {
                max = def;
            }
        }
        return max;
    }

    /**
     * 返回指定节点的索引
     *
     * @param parent
     * @return
     */
    private int pos(Node parent) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == parent) {
                return i;
            }
        }
        return -1;
    }

}
























