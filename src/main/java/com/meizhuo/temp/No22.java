package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No22
 * @Description 散步
 * @Date 2019/8/31 17:10
 * @Created by Gangan
 */
public class No22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int count = scanner.nextInt();
        int[] arrowLength = new int[count];
        for (int i = 0; i < arrowLength.length; i++) {
            arrowLength[i] = scanner.nextInt();
        }

        for (int i = 0; i <= length; i++) {
            find(i, 0, arrowLength, count, 1, length);
        }

    }

    public static int count = 0;

    public static void find(int currentPosition, int nextLengthIndex,
                            int[] arrowLength, int deep,
                            int currentDeep, int sum) {
        if (currentPosition + arrowLength[nextLengthIndex] <= sum ||
                currentPosition - arrowLength[nextLengthIndex] >= 0) {
            if (currentDeep == deep) {
                count++;
            } else {
                find(currentPosition + arrowLength[nextLengthIndex],
                        nextLengthIndex + 1,
                        arrowLength, deep, currentDeep + 1, sum);
                find(currentPosition - arrowLength[nextLengthIndex],
                        nextLengthIndex + 1,
                        arrowLength, deep, currentDeep + 1, sum);

            }
        }

    }

    public static void find_2(int currentPosition, int nextStep,int nextLengthIndex,
                              int[] arrowLength, int deep, int currentDeep, int sum) {
        if (currentPosition + nextStep > sum || currentPosition + nextStep < 0) {
            return;
        }
        if (currentDeep == deep) {
            count++;
        } else {
            find_2(currentPosition+nextStep,arrowLength[nextLengthIndex+1],
                    nextLengthIndex+1,arrowLength,deep,
                    currentDeep+1,sum);
            find_2(currentPosition+nextStep,-arrowLength[nextLengthIndex+1],
                    nextLengthIndex+1,arrowLength,deep,
                    currentDeep+1,sum);
        }
    }

}
