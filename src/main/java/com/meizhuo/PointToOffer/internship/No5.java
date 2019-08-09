package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No5
 * @Description 迷路的牛牛
 * @Date 2019/8/9 9:17
 * @Created by Gangan
 */
public class No5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String path = scanner.next();
        int target=0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'L') {
                if (target == 3) {
                    target = 0;
                } else {
                    target++;
                }
            } else {
                if (target == 0) {
                    target = 3;
                } else {
                    target--;
                }

            }
        }

        if (target == 0) {
            System.out.println("N");
        } else if (target == 1) {
            System.out.println("W");
        } else if (target == 2) {
            System.out.println("S");
        } else if (target == 3) {
            System.out.println("E");
        } else {
            System.out.println("Error");
        }
    }

}
