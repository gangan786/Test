package com.meizhuo.temp;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Classname No20
 * @Description 计算累计平方和
 * @Date 2019/8/25 18:02
 * @Created by Gangan
 */
public class No20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int sum = 0;
            while (sum != 1) {
                sum=0;
                while (target != 0) {
                    int a = target % 10;
                    sum += a * a;
                    target = target / 10;
                }
                target = sum;
                if (set.contains(sum)) {
                    System.out.println("false");
                    break;
                } else {
                    set.add(sum);
                }

            }

                System.out.println("true");
        }

    }

}
