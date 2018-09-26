package com.meizhuo.CrazyJava._11.TreeChild;

import java.util.ArrayList;
import java.util.List;

public class TreeChild<E> {

    private static class SonNode {
        private int pos;//记录当前子节点在数组中的位置
        private SonNode next;//保存下一个子节点

        public SonNode(int pos, SonNode next) {
            this.pos = pos;
            this.next = next;
        }
    }

    public class Node<T> {
        private SonNode first;//记录第一个子节点
        private T data;

        public Node(T data) {
            this.data = data;
            this.first = null;
        }

        @Override
        public String toString() {
            if (first != null) {
                return " TreeChild$Node[data=" + data + ",first=" + first.pos + "] ";
            } else {
                return " TreeChild$Node[data=" + data + ",first=-1] ";
            }
        }
    }

    private final static int DEFAULT_SIZE = 100;//默认容量
    private int treeSize = 0;//实际容量
    private int nodeNums;//节点数量
    private Node<E> nodes[];//保存所有节点的数组

    /**
     * 以指定元素创建
     *
     * @param data
     */
    public TreeChild(E data) {
        treeSize = DEFAULT_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data);
        nodeNums++;
    }

    /**
     * 以指定元素，容量创建
     *
     * @param data
     * @param treeSize
     */
    public TreeChild(E data, int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data);
        nodeNums++;
    }

    /**
     * 为指定父节点添加子节点
     *
     * @param data
     * @param parent
     */
    public Node<E> add(E data, Node parent) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == null) {
                //找到数组中第一个为null的空间，并用该控件保存新节点
                nodes[i] = new Node<>(data);//创建新节点，并用指定数组元素来保护它
                //接下来是将新节点与指定的父节点联系起来
                if (parent.first == null) {
                    parent.first = new SonNode(i, null);
                } else {
                    SonNode current = parent.first;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = new SonNode(i, null);
                }
                nodeNums++;
                return nodes[i];
            }
        }
        throw new RuntimeException("该树已满，无法添加新节点");
    }

    /**
     * 判断该树是否为空
     *
     * @return
     */
    public boolean empty() {
        return nodes[0] == null;
    }

    /**
     * 返回根节点
     *
     * @return
     */
    public Node<E> root() {
        return nodes[0];
    }

    /**
     * 返回指定节点的所有子节点
     *
     * @param parent
     * @return
     */
    public List<Node<E>> children(Node parent) {
        SonNode current = parent.first;
        List<Node<E>> list = new ArrayList<Node<E>>();
        while (current != null) {
            list.add(nodes[current.pos]);
            current = current.next;
        }
        return list;
    }

    /**
     * 返回指定节点（非叶子节点）的第index个子节点
     *
     * @param parent
     * @param index
     * @return
     */
    public Node<E> child(Node parent, int index) {
        SonNode current = parent.first;
        for (int i = 0; current != null; i++) {
            if (i == index) {
                return nodes[current.pos];
            } else {
                current = current.next;
            }
        }
        return null;
    }

    /**
     * 返回指定节点的数组索引
     *
     * @param node
     * @return
     */
    public int pos(Node node) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取指定索引的节点
     *
     * @param pos
     * @return
     */
    public Node<E> getNode(int pos) {
        if (pos < nodeNums) {
            return nodes[pos];
        } else {
            throw new IndexOutOfBoundsException("索引越界！！");
        }
    }

    /**
     * 返回该树的深度
     *
     * @return
     */
    public int deep() {
        return deep(root());
    }

    /**
     * 这个是一个递归方法：每棵子树的深度为其所有子树的最大深度+1
     *
     * @param node
     * @return
     */
    private int deep(Node<E> node) {
        if (node.first == null) {
            //不空则说明该节点有子节点
            return 1;
        } else {
            //记录所有子树的最大深度
            int max = 0;
            SonNode current = node.first;
            //沿着孩子链不断搜索下一个孩子点
            while (current != null) {
                int tmp = deep(nodes[current.pos]);
                if (tmp > max) {
                    max = tmp;
                }
                current = current.next;
            }
            //最后返回所有子树的最大深度+1
            return max + 1;
        }

    }

}




















