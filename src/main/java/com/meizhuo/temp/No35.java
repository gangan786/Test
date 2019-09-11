package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No35
 * @Description 礼物派发
 * @Date 2019/9/11 21:36
 * @Created by Gangan
 */
public class No35 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfCustomer = scanner.nextInt();
        int capacityA = scanner.nextInt();
        int capatityB = scanner.nextInt();
        int[][] cost = new int[2][countOfCustomer];
        for (int i = 0; i < countOfCustomer; i++) {
            cost[0][i] = scanner.nextInt();
            cost[1][i] = scanner.nextInt();
        }


    }

}
