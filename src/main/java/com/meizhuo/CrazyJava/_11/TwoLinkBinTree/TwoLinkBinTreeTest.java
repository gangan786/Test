package com.meizhuo.CrazyJava._11.TwoLinkBinTree;


import org.junit.Test;

public class TwoLinkBinTreeTest {
    @Test
    public void test() {
        TwoLinkBinTree<String> twoLinkBinTree = new TwoLinkBinTree<>("Gangan父亲");
        TwoLinkBinTree.TreeNode root = twoLinkBinTree.root();
        TwoLinkBinTree.TreeNode son1 = twoLinkBinTree.addNode("虚伪儿子1", root, true);
        TwoLinkBinTree.TreeNode son2 = twoLinkBinTree.addNode("虚伪儿子2", root, false);
        TwoLinkBinTree.TreeNode son3 = twoLinkBinTree.addNode("虚伪儿子3", son1, true);
        TwoLinkBinTree.TreeNode son4 = twoLinkBinTree.addNode("虚伪儿子4", son2, true);
        TwoLinkBinTree.TreeNode son5 = twoLinkBinTree.addNode("虚伪儿子5", son2, false);
        TwoLinkBinTree.TreeNode son6 = twoLinkBinTree.addNode("虚伪儿子6", son3, true);
        TwoLinkBinTree.TreeNode son7 = twoLinkBinTree.addNode("虚伪儿子7", son3, false);

        System.out.println("son6的父节点为：" + twoLinkBinTree.parent(son6));
        System.out.println("树的深度为：" + twoLinkBinTree.deep());

    }
}
