package com.meizhuo.CrazyJava._11.HufmanTree;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HuffmanTree {
    @Test
    public void test() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node<String>("虚伪儿子1", 6));
        nodes.add(new Node<String>("虚伪儿子2", 1));
        nodes.add(new Node<String>("虚伪儿子3", 2));
        nodes.add(new Node<String>("虚伪儿子4", 7));
        nodes.add(new Node<String>("虚伪儿子5", 9));
        nodes.add(new Node<String>("虚伪儿子6", 3));
        nodes.add(new Node<String>("虚伪儿子7", 4));
        nodes.add(new Node<String>("虚伪儿子8", 5));
        nodes.add(new Node<String>("虚伪儿子9", 10));
        nodes.add(new Node<String>("虚伪儿子10", 8));

        Node root = HuffmanTree.createTree(nodes);
        System.out.println(breathFirst(root));
        quickSort(nodes);
        for (Node node : nodes) {
            System.out.println(node.weight + "  " + node.data);
        }

    }

    public static class Node<E> {
        E data;
        double weight;
        Node leftNode;
        Node rightNode;

        public Node(E data, double weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node[data=" + data + ",weight=" + weight + "]";
        }
    }

    public static Node createTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            quickSort(nodes);
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null, left.weight + right.weight);
            parent.leftNode = left;
            parent.rightNode = right;
            nodes.remove(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static void quickSort(List<Node> nodes) {
        subSort(nodes, 0, nodes.size() - 1);
    }

    /**
     * 利用递归完成快速排序算法
     * @param nodes
     * @param start
     * @param end
     */
    private static void subSort(List<Node> nodes, int start, int end) {
        if (end > start) {
            Node base = nodes.get(start);//以第一个元素作为分界值
            int i = start;
            int j = end + 1;
            while (true) {
                while (i < end && nodes.get(++i).weight >= base.weight) ;//目的是定位到比base.weight小的那个索引
                while (j > start && nodes.get(--j).weight <= base.weight) ;//目的是定位到比base.weight大的那个索引
                if (i < j) {
                    swap(nodes, i, j);
                } else {
                    break;
                }
            }
            swap(nodes, start, j);
            subSort(nodes, start, j - 1);
            subSort(nodes, j + 1, end);

        }
    }

    private static void swap(List<Node> nodes, int i, int j) {
        Node tmp;
        tmp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

    /**
     * 采用广度优先遍历
     *
     * @param root
     * @return
     */
    public static List<Node> breathFirst(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();
            if (p.leftNode != null) {
                queue.offer(p.leftNode);
            }
            if (p.rightNode != null) {
                queue.offer(p.rightNode);
            }
        }
        return list;
    }

}
