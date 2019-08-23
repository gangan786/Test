package com.meizhuo.PointToOffer.internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Classname No21
 * @Description 搭积木
 * @Date 2019/8/23 10:28
 * @Created by Gangan
 */
public class No21 {

    static class Block {
        public int W;
        public int L;

        public Block(int w, int l) {
            W = w;
            L = l;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Block[] blocks = new Block[count];
        for (int i = 0; i < count; i++) {
            blocks[i] = new Block(scanner.nextInt(), scanner.nextInt());
        }

        //排序
        Arrays.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                if (o1.W != o2.W) {
                    return o1.W - o2.W;
                } else {
                    return o1.L - o2.L;
                }
            }
        });


        int valuable = 0;
        //动态规划寻找最长子串
        int[] dp = new int[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (blocks[j].L <= blocks[i].L) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            valuable=Math.max(valuable,dp[i]);
        }

        System.out.println(valuable);

    }


}
