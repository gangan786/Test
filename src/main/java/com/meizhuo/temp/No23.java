package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No23
 * @Description 宝藏
 * @Date 2019/9/1 20:05
 * @Created by Gangan
 */
public class No23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfBox = scanner.nextInt();
        int countOfKey = scanner.nextInt();
        int[] numOfBox = new int[countOfBox];
        int[] numOfKey = new int[countOfKey];

        for (int i = 0; i < numOfBox.length; i++) {
            numOfBox[i] = scanner.nextInt();
        }
        for (int i = 0; i < numOfKey.length; i++) {
            numOfKey[i] = scanner.nextInt();
        }

        //对宝箱数字单双进行统计
        int countOfBoxSingle = 0;
        int countOfBoxDouble = 0;
        for (int i = 0; i < numOfBox.length; i++) {
            if (numOfBox[i] % 2 == 0) {
                countOfBoxDouble++;
            } else {
                countOfBoxSingle++;
            }
        }
        //对钥匙数字单双进行统计
        int countOfKeySingle = 0;
        int countOfKeyDouble = 0;
        for (int i = 0; i < numOfKey.length; i++) {
            if (numOfKey[i] % 2 == 0) {
                countOfKeyDouble++;
            } else {
                countOfKeySingle++;
            }
        }

        System.out.println(Math.min(countOfBoxSingle, countOfKeyDouble) + Math.min(countOfBoxDouble, countOfKeySingle));

    }

}
