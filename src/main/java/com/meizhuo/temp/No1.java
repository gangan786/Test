package com.meizhuo.temp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Classname No1
 * @Description TODO
 * @Date 2019/8/3 15:23
 * @Created by Gangan
 */
public class No1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfStu = in.nextInt();
        int[] scoreList = new int[numOfStu];
        for (int i = 0; i < numOfStu; i++) {
            scoreList[i]=in.nextInt();
        }
        int countOfCheck = in.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < scoreList.length; i++) {
            priorityQueue.add(scoreList[i]);
        }



    }

}
