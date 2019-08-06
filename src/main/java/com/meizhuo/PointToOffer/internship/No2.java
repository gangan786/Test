package com.meizhuo.PointToOffer.internship;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Classname No2
 * @Description 牛客编程题：牛牛找工作
 * @Date 2019/8/6 14:47
 * @Created by Gangan
 */
public class No2 {

    public static void v1() {
        Scanner scanner = new Scanner(System.in);
        int countOfJobs = scanner.nextInt();
        int countOfFriends = scanner.nextInt();

        ArrayList<Work> jobList = new ArrayList<>(8);
        int[] costList = new int[countOfFriends];

        for (int i = 0; i < countOfJobs; i++) {
            jobList.add(new Work(scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < costList.length; i++) {
            costList[i] = scanner.nextInt();
        }

        for (int i = 0; i < costList.length; i++) {
            int cost = costList[i];
            int maxPay = 0;
            for (Work work : jobList) {
                if (cost >= work.cost && work.pay > maxPay) {
                    maxPay = work.pay;
                }
            }
            System.out.println(maxPay);
        }

    }

    static class Work {
        int cost;
        int pay;

        public Work(int cost, int pay) {
            this.cost = cost;
            this.pay = pay;
        }
    }


    public static void v2() {
        Scanner scanner = new Scanner(System.in);
        int countOfJobs = scanner.nextInt();
        int countOfFriends = scanner.nextInt();

        HashMap<Integer, Integer> costPay = new HashMap<>(countOfFriends + countOfJobs);

        int[] allCost = new int[countOfFriends + countOfJobs];
        int[] friendCost = new int[countOfFriends];

        for (int i = 0; i < countOfJobs; i++) {
            int curCost = scanner.nextInt();
            int curPay = scanner.nextInt();
            allCost[i] = curCost;
            costPay.put(curCost, curPay);
        }

        for (int i = 0; i < friendCost.length; i++) {
            int curFriCost = scanner.nextInt();
            friendCost[i] = curFriCost;
            allCost[i + countOfJobs] = curFriCost;
            if (!costPay.containsKey(curFriCost)) {
                costPay.put(curFriCost, 0);
            }
        }

        Arrays.sort(allCost);

        int maxPay = 0;
        for (int i = 0; i < allCost.length; i++) {
            maxPay = Math.max(maxPay, costPay.get(allCost[i]));
            costPay.put(allCost[i], maxPay);
        }

        for (int i = 0; i < friendCost.length; i++) {
            System.out.println(costPay.get(friendCost[i]));
        }

    }

    public static void main(String[] args) {
        v2();
    }


}
