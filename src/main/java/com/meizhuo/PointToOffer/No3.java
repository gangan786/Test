package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No3
 * @Description 找出重复的数字
 * @Date 2019/6/20 16:01
 * @Created by Gangan
 */
public class No3 {

    public boolean duplicate(int[] valus) {
        if (valus == null || valus.length == 0) {
            return false;
        }
        for (int i = 0; i < valus.length; i++) {
            if (valus[i] < 0 || valus[i] > valus.length - 1) {
                return false;
            }
        }

        for (int i = 0; i < valus.length; i++) {

            while (i != valus[i]) {
                if (valus[valus[i]] != valus[i]) {
                    int temp=valus[valus[i]];
                    valus[valus[i]]=valus[i];
                    valus[i]=temp;
                } else {
                    System.out.println("其中一个重复数字为："+valus[i]);
                    return true;
                }
            }

        }

        System.out.println("没有重复数字");
        return false;
    }

    @Test
    public void test() {
        int[] ints = {2, 6, 1, 0, 4, 5, 3};
        Integer integer = new Integer(-1);
        System.out.println("结果为：" + duplicate(ints));
    }

}
