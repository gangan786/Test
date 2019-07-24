package com.meizhuo.PointToOffer;

import org.junit.Test;


/**
 * @Classname No57
 * @Description 和为S的数
 * @Date 2019/7/24 14:44
 * @Created by Gangan
 */
public class No57 {

    @Test
    public void testFindNumWithSum() {
        int[] target = {1, 2, 4, 7, 11, 15};
        findNumWithSum(target, 15);
    }

    public void findNumWithSum(int[] target, int s) {

        if (target == null) {
            throw new NullPointerException();
        }

        int head = 0;
        int tail = target.length - 1;
        boolean isFound = false;
        while (head < tail) {
            int curSum = target[head] + target[tail];
            if (curSum == s) {
                isFound = true;
                System.out.println("head--> " + head +
                        "值-->" + target[head]
                        + "\ntail--> " + tail +
                        "值-->" + target[tail]);
                break;
            } else if (curSum > s) {
                tail--;
            } else {
                head++;
            }
        }
        if (!isFound) {
            System.out.println("无符合条件的数字");
        }
    }

    @Test
    public void testFindContinousSequence() {
        findContinousSequence(15);
    }

    public void findContinousSequence(int targetSum) {
        if (targetSum < 3) {
            return;
        }
        int begin = 1;
        int end = 2;
        int curSum = begin + end;
        int maxBeginIndex = (targetSum + 1) / 2;

        while (begin < maxBeginIndex) {
            if (curSum == targetSum) {
                printList(begin, end);
            }
            while (curSum > targetSum && begin < maxBeginIndex) {
                curSum -= begin;
                begin++;
                if (curSum == targetSum) {
                    printList(begin,end);
                }

            }

            end++;
            curSum += end;


        }
    }

    private void printList(int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
    }

}
