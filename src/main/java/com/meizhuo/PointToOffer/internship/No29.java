package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No29
 * @Description 在行列都排好序的矩阵中查找指定的数
 * @Date 2019/9/13 14:55
 * @Created by Gangan
 */
public class No29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int columns = scanner.nextInt();
        int target = scanner.nextInt();
        int[][] animals = new int[line][columns];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < columns; j++) {
                animals[i][j]=scanner.nextInt();
            }
        }

        int curLine=0;
        int curColumns=columns-1;
        while (curLine < line && curColumns >=0) {
            if (animals[curLine][curColumns] == target) {
                System.out.println("Yes");
                return;
            } else if (animals[curLine][curColumns] > target) {
                curColumns--;
            } else {
                curLine++;
            }
        }
        System.out.println("No");
    }

}
