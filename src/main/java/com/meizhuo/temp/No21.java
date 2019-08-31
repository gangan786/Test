package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No21
 * @Description 最多子串
 * @Date 2019/8/31 16:35
 * @Created by Gangan
 */
public class No21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        int[] counts = new int[26];

        char[] chars = target.toCharArray();

        int max=0;
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i]-'a']++;
        }

        for (int i = 0; i < counts.length; i++) {
            max=Math.max(max,counts[i]);
        }

        System.out.println(max);

    }

}
