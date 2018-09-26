package com.meizhuo.CrazyJava._11.ThreeLinkBinTree;


import org.junit.Test;

import java.util.List;

public class ThreeLinkBinTreeTest {

    @Test
    public void test() {
        ThreeLinkBinTree<String> threeLinkBinTree = new ThreeLinkBinTree<>("Gangan父亲");
        ThreeLinkBinTree.TreeNode root = threeLinkBinTree.root();
        ThreeLinkBinTree.TreeNode son1 = threeLinkBinTree.addNode("虚伪儿子1", root, true);
        ThreeLinkBinTree.TreeNode son2 = threeLinkBinTree.addNode("虚伪儿子2", root, false);
        ThreeLinkBinTree.TreeNode son3 = threeLinkBinTree.addNode("虚伪儿子3", son1, true);
        ThreeLinkBinTree.TreeNode son4 = threeLinkBinTree.addNode("虚伪儿子4", son2, true);
        ThreeLinkBinTree.TreeNode son5 = threeLinkBinTree.addNode("虚伪儿子5", son2, false);
        ThreeLinkBinTree.TreeNode son6 = threeLinkBinTree.addNode("虚伪儿子6", son3, true);
        ThreeLinkBinTree.TreeNode son7 = threeLinkBinTree.addNode("虚伪儿子7", son3, false);

        System.out.println("son6的父节点为：" + threeLinkBinTree.parent(son6));
        System.out.println("树的深度为：" + threeLinkBinTree.deep());

        List<String> list=threeLinkBinTree.preIterator();
        System.out.print("前序遍历的结果：");
        for (String node:list) {
            System.out.print(node+" ");
        }
        System.out.println("");

        List<String> list1=threeLinkBinTree.inIterator();
        System.out.print("中序遍历的结果：");
        for (String node:list1) {
            System.out.print(node+" ");
        }
        System.out.println("");

        List<String> list2=threeLinkBinTree.postIterator();
        System.out.print("后序遍历的结果：");
        for (String node:list2) {
            System.out.print(node+" ");
        }
        System.out.println("");

        List<String> list3=threeLinkBinTree.breadthFirst();
        System.out.print("广度优先遍历的结果：");
        for (String node:list3) {
            System.out.print(node+" ");
        }
    }

}
