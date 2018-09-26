package com.meizhuo.CrazyJava._11.TreeParent;


import org.junit.Test;

import java.util.List;

public class TreeParentTest {
    @Test
    public void test() {
        TreeParent<String> treeParent = new TreeParent<>("Ganagn父亲");
        TreeParent.Node root = treeParent.root();
        System.out.println(root);
        TreeParent.Node son1 = treeParent.addNode("虚伪儿子1", root);
        TreeParent.Node son2 = treeParent.addNode("虚伪儿子2", root);
        TreeParent.Node son3 = treeParent.addNode("虚伪儿子3", root);
        TreeParent.Node son4 = treeParent.addNode("虚伪儿子4", son1);
        TreeParent.Node son5 = treeParent.addNode("虚伪儿子5", son3);
        TreeParent.Node son6 = treeParent.addNode("虚伪儿子6", son3);
        TreeParent.Node son7 = treeParent.addNode("虚伪儿子7", son4);
        TreeParent.Node son8 = treeParent.addNode("虚伪儿子8", son4);
        TreeParent.Node son9 = treeParent.addNode("虚伪儿子9", son4);
        TreeParent.Node son10 = treeParent.addNode("虚伪儿子10", son6);
        System.out.println("这棵树的深度为："+treeParent.deep());
        List list=treeParent.children(son4);
        System.out.println(list.toString());
//        treeParent.parent(root);
        System.out.println("son7的父节点为："+treeParent.parent(son7));
    }
}
