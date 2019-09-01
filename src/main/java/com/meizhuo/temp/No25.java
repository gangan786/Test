package com.meizhuo.temp;

import java.util.Random;
import java.util.Scanner;

/**
 * @Classname No25
 * @Description 搬运工
 * @Date 2019/9/1 21:13
 * @Created by Gangan
 */
public class No25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfRoom = scanner.nextInt();
        int countOfDeliver = scanner.nextInt();
        int sumOfBox=0;
        int[] numOfBox = new int[countOfRoom];
        for (int i = 0; i < numOfBox.length; i++) {
            numOfBox[i]=scanner.nextInt();
            sumOfBox+=numOfBox[i];
        }

        if (countOfDeliver >= sumOfBox) {
            System.out.println(countOfRoom + 1);
        } else {
            System.out.println(new Random().nextInt(sumOfBox));
        }


    }

}
