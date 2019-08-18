package com.meizhuo.PointToOffer.internship;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Classname No13
 * @Description 整理房间
 * @Date 2019/8/18 19:54
 * @Created by Gangan
 */
public class No13 {

    static class Heap {
        public int x;
        public int y;
        public int a;
        public int b;

        public Heap(int x, int y, int a, int b) {
            this.x = x;
            this.y = y;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countOfHeap = scanner.nextInt();
        Heap[][] heapList = new Heap[countOfHeap][4];

        int[] result = new int[countOfHeap];

        for (int i = 0; i < countOfHeap; i++) {
            for (int j = 0; j < 4; j++) {
                heapList[i][j] = new Heap(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }
            result[i] = calculate(heapList, i);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static int calculate(Heap[][] heapList, int i) {
        Heap h1, h2, h3, h4;
        int count = 16;
        for (int j = 0; j < 4; j++) {
            h1 = rotating(heapList[i][0], j);
            for (int k = 0; k < 4; k++) {
                h2 = rotating(heapList[i][1], k);
                for (int l = 0; l < 4; l++) {
                    h3 = rotating(heapList[i][2], l);
                    for (int m = 0; m < 4; m++) {
                        h4 = rotating(heapList[i][3], m);
                        //已穷举出4个点的所有旋转可能结果
                        if (isSquare_2(h1, h2, h3, h4)) {
                            //得到正方形所移动的最小代价
                            count = Math.min(j + k + l + m, count);
                        }
                    }
                }
            }
        }
        return count == 16 ? -1 : count;
    }

    private static boolean isSquare(Heap h1, Heap h2, Heap h3, Heap h4) {
        Heap[] heaps = {h1, h2, h3, h4};
        PriorityQueue<Integer> length = new PriorityQueue<>(6, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < heaps.length - 1; i++) {
            for (int j = i+1; j < heaps.length; j++) {
                //四个点两两配对
                Heap a = heaps[i];
                Heap b = heaps[j];
                int hypot = (int) Math.hypot(a.x - b.x, a.y - b.y);
                length.add(hypot);

            }
        }

        Integer a = length.poll();
        Integer b = length.poll();
        Integer c = length.poll();
        Integer d = length.poll();
        Integer e = length.poll();
        Integer f = length.poll();

        if (a.equals(b) && b.equals(c) &&
                c.equals(d) && !d.equals(e) && e.equals(f)) {
            return true;
        }else {
            return false;
        }
    }

    private static boolean isSquare_2(Heap p1, Heap p2, Heap p3, Heap p4) {

        boolean rx = ((p1.x) ^ (p2.x) ^ (p3.x) ^ (p4.x)) == 0;
        //四个点的 x 坐标是否是两两相等
        boolean ry = ((p1.y) ^ (p2.y) ^ (p3.y) ^ (p4.y)) == 0;
        //四个点的 y 坐标是否是两两相等
        //是否是矩形
        if (!rx || !ry || rx && ry && (p1.x == p2.x && p1.x == p3.x) ||
                rx && ry && (p1.y == p2.y && p1.y == p3.y)){
            return false;}

        //判断正方形
        int dx = Math.abs((p1.x - p2.x) != 0 ? (p1.x - p2.x) : (p1.x - p3.x));
        int dy = Math.abs((p1.y - p2.y) != 0 ? (p1.y - p2.y) : (p1.y - p3.y));
        return dx == dy;
    }


    private static Heap rotating(Heap heap, int timeOfRotating) {
        int x = heap.x;
        int y = heap.y;
        int a = heap.a;
        int b = heap.b;
        for (int i = 0; i < timeOfRotating; i++) {
            int temp = x;
            x = b - y + a;
            y = temp - a + b;
        }
        return new Heap(x, y, a, b);
    }

}
