package com.meizhuo.CrazyJava._12;


import org.junit.Test;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            builMaxHeap(data, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(data, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(data));
        }
    }

    //对data数组从0到lastIndex建大顶堆
    private static void builMaxHeap(DataWrap[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {//i拿到的是lastIndex的父节点的索引
            //k保存当前正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左节点的索引
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    //这段判断语句的作用是获取较大节点的索引
                    //如果biggerIndex小于biggerIndex，即biggerIndex+1代表的k节点的右节点存在
                    if (data[biggerIndex].compareTo(data[biggerIndex + 1]) < 0) {
                        //如果右节点的值比较大
                        biggerIndex++;//总是记录较大节点的索引
                    }
                }
                if (data[k].compareTo(data[biggerIndex]) < 0) {
                    //如果k节点的值小于其较大节点的值，交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋给k，开始while循环的下一次循环
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(DataWrap[] data, int i, int j) {
        DataWrap tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    @Test
    public void test() {
        DataWrap data[] = {
                new DataWrap(21, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, ""),
                new DataWrap(21, "*"),
                new DataWrap(16, ""),
                new DataWrap(9, ""),
        };
        System.out.println("排序之前：\n" + Arrays.toString(data));
        heapSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }

}
