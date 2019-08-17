package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No9
 * @Description 背包装零食
 * @Date 2019/8/17 13:36
 * @Created by Gangan
 */
public class No9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] capacitys = new int[count];
        long max = 0;
        for (int i = 0; i < capacitys.length; i++) {
            capacitys[i] = scanner.nextInt();
            max += capacitys[i];
        }
        if (sum >= max) {
            System.out.println((int)Math.pow(2, count));
        } else {
            System.out.println(state(count - 1, sum, capacitys));
        }

    }

    private static int state(int index, int capacity, int[] capacitys) {
        if (capacity <= 0) {
            return 0;
        }
        if (index == 0) {
            if (capacitys[index] <= capacity) {
                return 2;
            } else {
                return 1;
            }
        }

        return state(index - 1, capacity - capacitys[index], capacitys) +
                state(index - 1, capacity, capacitys);
    }

}
