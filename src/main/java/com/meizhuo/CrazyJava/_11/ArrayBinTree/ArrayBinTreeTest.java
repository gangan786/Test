package com.meizhuo.CrazyJava._11.ArrayBinTree;

import org.junit.Test;
public class ArrayBinTreeTest {
    @Test
    public void test() {
        ArrayBinTree<String> arrayBinTree = new ArrayBinTree<>(4, "Gangan父亲");
        System.out.println("父节点为：" + arrayBinTree.root());
        int root = arrayBinTree.pos(arrayBinTree.root());
        int son1 = arrayBinTree.add(root, "虚伪儿子1", true);
        int son2 = arrayBinTree.add(root, "虚伪儿子2", false);
        int son3 = arrayBinTree.add(son1, "虚伪儿子3", true);
        int son4 = arrayBinTree.add(son1, "虚伪儿子4", false);
        int son5 = arrayBinTree.add(son2, "虚伪儿子5", true);
        int son6 = arrayBinTree.add(son2, "虚伪儿子6", false);
        int son7 = arrayBinTree.add(son3, "虚伪儿子7", true);
        int son8 = arrayBinTree.add(son3, "虚伪儿子8", true);
        int son9 = arrayBinTree.add(son4, "虚伪儿子9", true);
        System.out.println(arrayBinTree.toString());

        System.out.println("--------------------------------------------------------------------------------------------");

        //空间大量浪费测试代码
        ArrayBinTree<String> rightArrayBinTree1 = new ArrayBinTree<>(4, "第一层：A");
        rightArrayBinTree1.add(0, "第二层：B", false);
        rightArrayBinTree1.add(2, "第三层：C", false);
        rightArrayBinTree1.add(6, "第四层：D", false);
        System.out.println(rightArrayBinTree1.toString());

    }
}
