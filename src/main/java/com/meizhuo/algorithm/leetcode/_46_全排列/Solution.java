package com.meizhuo.algorithm.leetcode._46_全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Date 2019/4/20 10:31
 * @Created by Gangan
 */
public class Solution {
    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
        generatePermutation(nums, 0, integerLinkedList);

        return res;
    }

    // integerLinkList 中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> integerLinkedList) {

        if (index == nums.length) {
            res.add((LinkedList<Integer>) integerLinkedList.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                integerLinkedList.addLast(nums[i]);
                generatePermutation(nums, index + 1, integerLinkedList);
                integerLinkedList.removeLast();
                used[i] = false;
            }
        }
        return;
    }

    private static void printList(List<Integer> list) {

        for (Integer e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution()).permute(nums);
        for (List<Integer> list : res) {
            printList(list);
        }
    }
}
