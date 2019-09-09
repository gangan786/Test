package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No32
 * @Description 最近公共节点
 * @Date 2019/9/9 20:06
 * @Created by Gangan
 */
public class No32 {

    static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int leval = scanner.nextInt();
        int[] tree = new int[leval * leval];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = scanner.nextInt();
        }

        Node root = buildBinaryTree(tree, 1);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.println(findLowestAncestor(root, n1, n2).value);

    }

    public static Node buildBinaryTree(int[] target, int index) {
        if (index >= target.length) {
            return null;
        } else {
            Node root = new Node();
            root.value = target[index];
            root.left = buildBinaryTree(target, index * 2);
            root.right = buildBinaryTree(target, index * 2 + 1);
            return root;
        }
    }

    public Node lowestCommonAncestor1(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Node l = lowestCommonAncestor1(root.left, p, q);
        Node r = lowestCommonAncestor1(root.right, p, q);
        return l != null && r != null ? root : l == null ? r : l;
    }

    public static Node findLowestAncestor(Node root,int n1,int n2) {
        if (root.value > Math.min(n1, n2) && root.value < Math.max(n1, n2)) {
            return root;
        } else if (root.value < n1 && root.value < n2) {
            return findLowestAncestor(root.right, n1, n2);
        } else {
            return findLowestAncestor(root.left, n1, n2);
        }
    }

}
