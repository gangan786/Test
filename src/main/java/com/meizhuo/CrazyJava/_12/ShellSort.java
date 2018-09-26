package com.meizhuo.CrazyJava._12;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        //h变量保存可变增量
        int h = 1;
        //按 h * 3 + 1 得到增量序列的最大值
        while (h <= arrayLength) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("===h的值：" + h + "===");
            for (int i = h; i < arrayLength; i++) {
                //当整体后移时，保证data[i]的值不会丢失
                DataWrap tmp = data[i];
                if (data[i].compareTo(data[i - h]) < 0) {
                    int j = i - h;
                    for (; j >= 0 && data[j].compareTo(tmp) > 0; j -= h) {
                        data[j + h] = data[j];
                    }
                    data[j + h] = tmp;
                }
                System.out.println(Arrays.toString(data));
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        DataWrap data[] = {
                new DataWrap(9, ""),
                new DataWrap(-16, ""),
                new DataWrap(21, "*"),
                new DataWrap(23, ""),
                new DataWrap(-30, ""),
                new DataWrap(-49, ""),
                new DataWrap(21, ""),
                new DataWrap(30, "*"),
                new DataWrap(30, "")
        };
        System.out.println("排序之前：" + Arrays.toString(data));
        shellSort(data);
        System.out.println("排序之后：" + Arrays.toString(data));
    }
}
