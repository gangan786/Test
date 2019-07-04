package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No33
 * @Description 二叉搜索树的后序遍历
 * @Date 2019/7/4 15:22
 * @Created by Gangan
 */
public class No33 {

    @Test
    public void test() {
        int[] target = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(verifySquenceOfBST(target, 0, target.length));
    }

    public boolean verifySquenceOfBST(int[] target, int startIndex, int length) {
        if (target == null || startIndex + length > target.length) {
            throw new IllegalArgumentException("参数非法");
        }

        int endIndex = startIndex + length - 1;
        int root = target[endIndex];

        int i = startIndex;
        for (; i < endIndex; i++) {
            if (target[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < endIndex; j++) {
            if (target[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > startIndex) {
            left = verifySquenceOfBST(target, startIndex, i - startIndex);
        }
        boolean right = true;
        if (i < endIndex) {
            right = verifySquenceOfBST(target, i, length - i - 1);
        }

        return (left && right);

    }

}
