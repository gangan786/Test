package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No31
 * @Description 结束进程树
 * @Date 2019/9/9 19:21
 * @Created by Gangan
 */
public class No31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] counts = new int[101];
        String[] selfID = scanner.nextLine().split(" ");
        for (int i = 0; i < selfID.length; i++) {
            counts[Integer.valueOf(selfID[i])] = 1;
        }

        String[] parentID = scanner.nextLine().split(" ");
        for (int i = 0; i < parentID.length; i++) {
            Integer value = Integer.valueOf(parentID[i]);
            if (value != 0) {
                counts[value]++;
            }
        }


        int targetProcess = scanner.nextInt();
        System.out.println(counts[targetProcess]);

    }

}
