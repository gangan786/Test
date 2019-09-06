package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No29
 * @Description 守望者的逃离
 * @Date 2019/9/6 20:38
 * @Created by Gangan
 */
public class No29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initBuff = scanner.nextInt();
        int length = scanner.nextInt();
        int maxLength = 0;
        int time = scanner.nextInt();
        int consumeTime = 0;

            while (time > consumeTime) {
                if (initBuff - 10 >= 0) {
                    maxLength += 50;
                    consumeTime++;
                    initBuff -= 10;
                } else {
                    if (length - maxLength <= 13) {
                        consumeTime++;
                        maxLength += 13;
                    } else {
                        initBuff += 4;
                        consumeTime++;
                    }
                }
                if (length <= maxLength) {
                    System.out.println("Yes " + consumeTime);
                    break;
                }
            }

            if (maxLength<length) {
                System.out.println("No " + maxLength);
            }


    }

}
