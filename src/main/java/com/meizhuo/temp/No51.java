package com.meizhuo.temp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname No51
 * @Description 资金匹配
 * @Date 2019/9/21 15:40
 * @Created by Gangan
 */
public class No51 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] target = scanner.nextLine().split(",");
        int moneny = scanner.nextInt();
        int[] points = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            points[i] = Integer.parseInt(target[i]);
        }

        Arrays.sort(points);

        numGroup(points, 0, points.length, moneny);
    }

    static int[] flag = new int[1024];
    static int index = 0;

    private static void numGroup(int[] points, int start, int length, int moneny) {
        if (moneny == 0) {
            for (int j = 0; j < index; j++) {
                System.out.print(flag[j]);
            }
        } else {
            for (int i = start; i < length; i++) {
                flag[index++] = points[i];
                numGroup(points, i + 1, length - 1, moneny - points[i]);
            }
        }
        index--;
    }

}
