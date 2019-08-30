package com.meizhuo.PointToOffer.internship;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname No27
 * @Description 字符串排序
 * @Date 2019/8/30 16:53
 * @Created by Gangan
 */
public class No27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] results = new int[count];
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < count; i++) {
            temp.append(scanner.next());
            temp.delete(0,temp.length()-6);
            results[i]=Integer.valueOf(temp.toString());
            temp.delete(0,temp.length());
        }

        Arrays.sort(results);

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }

    }

}
