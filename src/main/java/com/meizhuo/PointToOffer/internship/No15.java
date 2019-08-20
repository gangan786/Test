package com.meizhuo.PointToOffer.internship;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname No15
 * @Description 塔
 * @Date 2019/8/20 14:43
 * @Created by Gangan
 */
public class No15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfTower = scanner.nextInt();
        int timeOfOper = scanner.nextInt();
        int[] heights = new int[countOfTower];
        ArrayList<String> position = new ArrayList<>(10);

        for (int i = 0; i < heights.length; i++) {
            heights[i] = scanner.nextInt();
        }

        int minOper = 0;
        for (int i = 0; i < timeOfOper; i++) {
            int maxIndex = max(heights);
            int minIndex = min(heights);
            //塔差
            int a = heights[maxIndex] - heights[minIndex];
            if (a > 1) {
                heights[maxIndex]--;
                heights[minIndex]++;
                minOper++;
                //记录迁移过程
                position.add((maxIndex + 1) + " " + (minIndex + 1));
            } else  {
                break;
            }
        }

        //最终塔差 和 最小操作次数
        System.out.println(heights[max(heights)] - heights[min(heights)] + " " + minOper);
        for (int i = 0; i < minOper; i++) {
            System.out.println(position.get(i));
        }


    }

    public static int min(int[] target) {
        int minIndex = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[minIndex] > target[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int max(int[] target) {
        int maxIndex = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[maxIndex] < target[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
