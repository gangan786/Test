package com.meizhuo.CrazyJava._11.SortedBinTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortedBinTree<T extends Comparable> {
    static class Node {
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[data = " + data + "]";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj.getClass() == Node.class) {
                Node node = (Node) obj;
                return data.equals(node)
                        && left == node.left
                        && right == node.right
                        && parent == node.parent;
            }
            return false;
        }
    }

    private Node root;//用于保存根节点

    public SortedBinTree() {
        root = null;
    }

    public SortedBinTree(T data) {
        root = new Node(data, null, null, null);
    }

    /**
     * 添加节点
     *
     * @param data
     */
    public void add(T data) {
        if (root == null) {
            //如果根节点为null
            root = new Node(data, null, null, null);
        } else {
            Node current = root;
            Node parent = null;
            int comp = 0;
            //找到满足条件的叶子节点及其父节点
            do {
                comp = data.compareTo(current.data);
                parent = current;
                if (comp > 0) {
                    current = current.right;
                } else {
                    //相同的可以放左边
                    current = current.left;
                }
            } while (current != null);

            //创建新节点
            Node newNode = new Node(data, parent, null, null);
            //判断新节点该放父节点的哪边
            if (comp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
    }

    /**
     * 移除一个元素
     *
     * @param data
     */
    public void remove(T data) {
        Node target = getNode(data);
        if (target == null) {
            return;
        }
        if (target.left == null && target.right == null) {
            //左右子树为空
            if (target == root) {
                root = null;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = null;
                } else {
                    target.parent.right = null;
                }
                target.parent = null;
            }
        } else if (target.left != null && target.right == null) {
            //左子树不为空，右子树为空
            if (target == root) {
                root = target.left;
                target.left.parent = null;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = target.left;
                } else {
                    target.parent.right = target.left;
                }
                target.left.parent = target.parent;
            }
        } else if (target.left == null && target.right != null) {
            //左子树为空，右子树不为空
            if (target == root) {
                root = target.right;
                target.right.parent = null;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = target.right;
                } else {
                    target.parent.right = target.right;
                }
                target.right.parent = target.parent;
            }
        } else if (target.left != null && target.right != null) {
            Node leftNaxNode = target.left;//用leftMaxNode保存target左子树中值最大的节点
            //搜索target左子树中值最大的节点
            while (leftNaxNode.right != null) {
                leftNaxNode = leftNaxNode.right;
            }
            leftNaxNode.parent.right = null;//从原来的子树中删除leftMaxNode节点
            leftNaxNode.parent = target.parent;//让leftMaxNode的parent指向target的parent
            if (target == target.parent.left) {
                //被删除节点是其父节点的左节点
                target.parent.left = leftNaxNode;
            } else {
                target.parent.right = leftNaxNode;
            }
            leftNaxNode.left = target.left;
            leftNaxNode.right = target.right;
            target.parent = target.left = target.right = null;
        }
    }

    /**
     * 根据值找到节点
     *
     * @param data
     * @return
     */
    private Node getNode(T data) {
        Node p = root;
        while (p != null) {
            int comp = data.compareTo(p.data);
            if (comp < 0) {
                p = p.left;
            } else if (comp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public List<T> breadthFirst() {
        Queue<Node> queue = new ArrayDeque<>();
        List<T> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add((T) queue.peek().data);
            Node p = queue.poll();
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
