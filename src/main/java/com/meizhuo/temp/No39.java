package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No39
 * @Description 传送门
 * @Date 2019/9/15 19:55
 * @Created by Gangan
 */
public class No39 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfCity = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int[] nextCity = new int[countOfCity + 1];
        for (int i = 1; i < nextCity.length; i++) {
            nextCity[i] = scanner.nextInt();
        }
        int maxValue = nextCity[0];
        int maxIndex = 0;
        for (int i = 0; i < nextCity.length; i++) {
            if (nextCity[i] > maxValue) {
                maxIndex = i;
                maxValue = nextCity[i];
            }
        }
        int result = 0;
        if (nextCity[1] > maxIndex) {
            result += ((nextCity[1] - maxIndex + A) * B);
            int length = countOfCity - maxValue;
            result += ((length + A) * C);
        }
        System.out.println(result);
    }

}
