package com.meizhuo.PointToOffer.internship;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Classname No42
 * @Description 生成窗口的最大值
 * @Date 2019/9/17 15:11
 * @Created by Gangan
 */
public class No42 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int winSize = scanner.nextInt();
        int[] points = new int[count];
        for (int i = 0; i < points.length; i++) {
            points[i] = scanner.nextInt();
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {

            //维护队尾
            while (true) {
                if (queue.isEmpty() || points[queue.getLast()] > points[i]) {
                    queue.addLast(i);
                    break;
                } else {
                    queue.removeLast();
                }
            }
            //维护队首
            if (i > winSize - 1 && i - winSize >= queue.getFirst()) {
                queue.removeFirst();
            }

            if (i >= winSize - 1) {
                System.out.print(points[queue.getFirst()] + " ");
            }

        }
    }

}
