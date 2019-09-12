package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No36
 * @Description 有序数组去重
 * @Date 2019/9/12 20:39
 * @Created by Gangan
 */
public class No36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] target = scanner.nextLine().split(",");
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < target.length; i++) {
            max=Math.max(max,Integer.valueOf(target[i]));
        }
        boolean[] isExit = new boolean[max+1];
        int count=0;
        for (int i = 0; i < target.length; i++) {
            Integer value = Integer.valueOf(target[i]);
            if (!isExit[value]) {
                isExit[value]=true;
                count++;
            }
        }

        System.out.println(count);

    }

}
