package com.meizhuo.CrazyJava._11.HufmanTree;

import java.util.List;

public class Test {



    private static void subSouyrt(List<HuffmanTree.Node> nodes, int start, int end) {
        if (end > start) {
            HuffmanTree.Node base = nodes.get(start);//以第一个元素作为分界值
            int i = start;
            int j = end - 1;
            while (true) {
                while (i < end && nodes.get(++i).weight >= base.weight) ;
                while (j > start && nodes.get(--j).weight <= base.weight) ;
                if (i < j) {
                    swap(nodes, i, j);
                } else {
                    break;
                }
                swap(nodes, start, j);
                subSouyrt(nodes, start, j - 1);
                subSouyrt(nodes, j + 1, end);
            }


        }
    }

    private static void swap(List<HuffmanTree.Node> nodes, int i, int j) {
        HuffmanTree.Node tmp;
        tmp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

}
