package com.meizhuo.PointToOffer.internship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Classname No7
 * @Description 多个矩形，最多重叠的部分
 * @Date 2019/8/13 23:13
 * @Created by Gangan
 */
public class No7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        for (int i = 0; i < n; i++) {
            x1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x2[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y2[i] = in.nextInt();
        }
        int ans = 0;
        int cnt = 0;
        for (int x : x1) {
            for (int y : y1) {
                for (int i = 0; i < n; i++) {
                    if (x >= x1[i] && x < x2[i] && y >= y1[i] && y < y2[i]) {
                        cnt++;
                    }
                }
                if (cnt > ans) {
                    ans = cnt;
                }
                cnt = 0;
            }
        }
        System.out.println(ans);
    }


}
