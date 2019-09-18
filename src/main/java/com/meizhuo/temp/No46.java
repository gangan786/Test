package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No46
 * @Description 最大连续子序列的和
 * @Date 2019/9/18 21:40
 * @Created by Gangan
 */
public class No46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder target = new StringBuilder(scanner.nextLine());
        target.replace(0,1,"");
        target.replace(target.length()-1,target.length(),"");
        String[] split = target.toString().split(", ");
        int[] points = new int[split.length];
        for (int i = 0; i < points.length; i++) {
            points[i]=Integer.valueOf(split[i]);
        }

        System.out.println(findGreatestOfSubArray(points));
    }

    public static boolean isValid = false;

    public static int findGreatestOfSubArray(int[] target) {
        if (target == null || target.length == 0) {
            isValid = false;
            throw new NullPointerException();
        }
        isValid = true;
        int curSum = 0;
        int maxSum = curSum;
        for (int i = 0; i < target.length; i++) {
            if (curSum <= 0) {
                curSum = target[i];
            }else {
                curSum += target[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

}
