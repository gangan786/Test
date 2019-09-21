package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No52
 * @Description 小球移动
 * @Date 2019/9/21 19:28
 * @Created by Gangan
 */
public class No52 {

    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        int colums = scanner.nextInt();
        go(1, 1, lines, colums);
        System.out.println(result);
    }

    private static void go(int curX, int curY, int lines, int colums) {
        if (curX == lines && curY == colums) {
            result++;
        } else {
            if (curX < lines) {
                go(curX + 1, curY, lines, colums);
            }
            if (curY < colums) {
                go(curX, curY + 1, lines, colums);
            }
        }
    }

}
