package com.meizhuo.InterviewGuide;



import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description 最大值减去最小值小于或等于num的子数组数量
 * https://www.nowcoder.com/practice/5fe02eb175974e18b9a546812a17428e?tpId=101&difficulty=&judgeStatus=&tags=&title=&sourceUrl=&gioEnter=menu
 * @Date 2022/4/25
 * @Created by Gangan
 * 20 290516
 * -232004 338028 -421441 637677 753499 595611 784268 -106853 -360216 701981 43869 -965250 335771 507555 429251 -945890 -923495 422049 260582 -566803
 */
public class No1_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] target = new int[length];
        int num = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            target[i] = scanner.nextInt();
        }
        System.out.println(getResult(target, num));
    }

    public static int getResult(int[] target, int num) {
        if (target == null || target.length == 0 || num < 0) {
            return  0;
        }
        int i = 0;
        int j = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int result = 0;
        while (i < target.length) {
            while (j < target.length) {
                if (qmin.isEmpty() || qmin.peekLast() != j) {
                    while (!qmin.isEmpty() && target[qmin.peekLast()] >= target[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    while (!qmax.isEmpty() && target[qmax.peekLast()] <= target[j]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                if (target[qmax.getFirst()] - target[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            result += j - i;
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            i++;
        }
        return result;
    }

}
