package com.meizhuo.CrazyJava._12;


import org.junit.Test;

import java.util.Arrays;

public class SelectSortPlus {

    public static void selectSort(DataWrapPlus[] datas) {
        System.out.println("开始排序");
        int arrayLength = datas.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                //获取最小值的索引
                if (datas[minIndex].compareTo(datas[j]) > 0) {
                    minIndex = j;//将j的值赋给minIndex
                }
            }

            if (minIndex != i) {
                DataWrapPlus temp = datas[i];
                datas[i] = datas[minIndex];
                datas[minIndex] = temp;
            }

            System.out.println("第" + (i + 1) + "趟比较后的结果为：" + Arrays.toString(datas));
        }
    }

    @Test
    protected void test() {
        DataWrapPlus[] datas = {
                new DataWrapPlus(21, ""),
                new DataWrapPlus(30, ""),
                new DataWrapPlus(49, ""),
                new DataWrapPlus(30, "*"),
                new DataWrapPlus(16, ""),
                new DataWrapPlus(9, ""),
        };

        System.out.println("排序之前为：\n" + Arrays.toString(datas));
        selectSort(datas);
        System.out.println("排序之后为： \n" + Arrays.toString(datas));

    }

}

class DataWrapPlus implements Comparable<DataWrapPlus> {

    int data;
    String flag;

    public DataWrapPlus(int data, String flag) {
        this.data = data;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return data + flag;
    }

    @Override
    public int compareTo(DataWrapPlus o) {
        return this.data > o.data ? 1 : (this.data == o.data ? 0 : -1);
    }
}