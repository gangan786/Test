package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No4
 * @Description 安置路灯
 * @Date 2019/8/7 15:07
 * @Created by Gangan
 */
public class No4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfExample = scanner.nextInt();

        for (int i = 0; i < countOfExample; i++) {
            int length = scanner.nextInt();
            String suitation = scanner.next();
            int count=0;
            for (int j = 0; j < length; j++) {
                if (suitation.charAt(j) == '.') {
                    count++;
                    j+=2;
                }
            }
            System.out.println(count);
        }

    }

}
