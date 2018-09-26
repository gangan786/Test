package com.meizhuo.CrazyJava._11.SortedBinTree;


import org.junit.Test;

public class SortedBinTreeTest {
    @Test
    public void test() {
        SortedBinTree<Integer> sortedBinTree = new SortedBinTree<>();
        sortedBinTree.add(5);
        sortedBinTree.add(3);
        sortedBinTree.add(20);
        sortedBinTree.add(10);
        sortedBinTree.add(30);
        sortedBinTree.add(8);
        sortedBinTree.add(15);
        sortedBinTree.add(28);
        sortedBinTree.add(31);
        System.out.println(sortedBinTree.breadthFirst());
        sortedBinTree.remove(20);
        System.out.println(sortedBinTree.breadthFirst());

    }
}
