package com.meizhuo.CrazyJava._11.TreeChild;



import org.junit.Test;

import java.util.List;

public class TreeChildTest {

    @Test
    public void test(){
        TreeChild<String> treeChild=new TreeChild<>("Gangan父亲");
        TreeChild.Node root=treeChild.root();
        TreeChild.Node son1=treeChild.add("虚伪儿子1",root);
        TreeChild.Node son2=treeChild.add("虚伪儿子2",root);
        TreeChild.Node son3=treeChild.add("虚伪儿子3",root);
        TreeChild.Node son4=treeChild.add("虚伪儿子4",son1);
        TreeChild.Node son5=treeChild.add("虚伪儿子5",son3);
        TreeChild.Node son6=treeChild.add("虚伪儿子6",son3);
        TreeChild.Node son7=treeChild.add("虚伪儿子7",son4);
        TreeChild.Node son8=treeChild.add("虚伪儿子8",son4);
        TreeChild.Node son9=treeChild.add("虚伪儿子9",son4);
        TreeChild.Node son10=treeChild.add("虚伪儿子10",son6);
        System.out.println("这棵树的深度为："+treeChild.deep());
        List list1=treeChild.children(root);
        System.out.println("根节点的子节点为："+list1.toString());
        List list=treeChild.children(son4);
        System.out.println("节点4的子节点为："+list.toString());
    }

}
