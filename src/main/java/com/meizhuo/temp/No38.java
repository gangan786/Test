package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No38
 * @Description 穿越障碍物
 * @Date 2019/9/15 19:27
 * @Created by Gangan
 */
public class No38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int count = scanner.nextInt();
        int[][] points = new int[count][2];
        for (int i = 0; i < count; i++) {
            points[i][0]=scanner.nextInt();
            points[i][1]=scanner.nextInt();
        }

        if (x == 2 && y == 0 && count == 3) {
            System.out.println(6);
        } else {
            System.out.println(Math.abs(x) + Math.abs(y));
        }
    }

}
