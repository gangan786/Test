package com.meizhuo.InterviewGuide;

import java.util.Scanner;

public class No8_15_奇数下标都是奇数或者偶数下标都是偶数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int length = in.nextInt();
        int[] target = new int[length];
        for (int i = 0; i < target.length; i++) {
            target[i] = in.nextInt();
        }
        int[] solution = solution(target);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int[] target) {
        int evenIndex = 0;
        int oddIndex = 1;
        int endIndex = target.length - 1;
        while (evenIndex <= endIndex && oddIndex <= endIndex) {
            if ((target[endIndex] & 1) == 1) {
                //单数
                swap(oddIndex, endIndex, target);
                oddIndex += 2;
            } else {
                swap(evenIndex, endIndex, target);
                evenIndex += 2;
            }
        }
        return target;
    }

    private static void swap(int left, int right, int[] target) {
        int temp = target[left];
        target[left] = target[right];
        target[right] = temp;
    }
}
