package com.meizhuo.CrazyJava._12;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SelectSort {

    public static void selectSort(DataWrap[] datas) {
        System.out.println("开始排序");
        int arrayLength = datas.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (datas[i].compareTo(datas[j]) > 0) {
                    DataWrap temp = datas[i];
                    datas[i] = datas[j];
                    datas[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟比较后的结果为：" + Arrays.toString(datas));
        }
    }

    @Test
    protected void test() {
        DataWrap[] datas = {
                new DataWrap(21, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
                new DataWrap(9, ""),
        };

        System.out.println("排序之前为：\n" + Arrays.toString(datas));
        selectSort(datas);
        System.out.println("排序之后为： \n" + Arrays.toString(datas));

    }

}

class DataWrap implements Comparable<DataWrap> {

    int data;
    String flag;

    public DataWrap(int data, String flag) {
        this.data = data;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return data + flag;
    }

    @Override
    public int compareTo(DataWrap o) {
        return this.data > o.data ? 1 : (this.data == o.data ? 0 : -1);
    }
}
