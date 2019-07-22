package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No53
 * @Description 在排序数组中查找数字
 * @Date 2019/7/22 14:48
 * @Created by Gangan
 */
public class No53 {

    @Test
    public void test() {
        int[] target = {1, 1, 2, 2, 2, 2, 3, 4, 6};
        System.out.println(getCountOfK(target, 2));
    }


    public int getCountOfK(int[] target, int k) {

        if (target == null) {
            throw new NullPointerException();
        }

        int firstKIndex = getFirstK(target, k, 0, target.length - 1);
        int lastKIndex = getLastK(target, k, 0, target.length - 1);
        if (firstKIndex > -1 && lastKIndex > -1) {
            return lastKIndex - firstKIndex + 1;
        } else {
            return 0;
        }
    }

    /**
     * 用二分法查看有序数组中K第一次出现时的下标
     *
     * @param target
     * @param k
     * @param start
     * @param end
     * @return
     */
    public int getFirstK(int[] target, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = start + (end - start) / 2;
        int middleData = target[middleIndex];

        if (middleData == k) {
            if ((middleIndex > 0
                    && target[middleIndex - 1] != k)
                    || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (k > middleData) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getFirstK(target, k, start, end);
    }

    /**
     * 用二分法查看有序数组中K最后一次出现时的下标
     *
     * @param target
     * @param k
     * @param start
     * @param end
     * @return
     */
    public int getLastK(int[] target, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = start + (end - start) / 2;
        int middleData = target[middleIndex];

        if (middleData == k) {
            if ((middleIndex < target.length - 1
                    && target[middleIndex + 1] != k)
                    || middleIndex == target.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (k > middleData) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getLastK(target, k, start, end);
    }

    @Test
    public void testGetMissingNum() {
        int[] target = {0, 1, -1, 3, 4};
        System.out.println(getMissingNum(target));
    }

    /**
     * 查找 0 ~ n-1 中缺失的那个数
     * @param target
     * @return
     */
    public int getMissingNum(int[] target) {
        if (target == null) {
            throw new NullPointerException();
        }

        int left = 0;
        int right = target.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target[middle] != middle) {
                if (middle == 0 || target[middle - 1] == middle - 1) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            } else {
                left = middle + 1;
            }
        }

        if (left == target.length) {
            return left;
        }
        return -1;
    }

    @Test
    public void testGetNumSameAsIndex() {
        int[] target = {-3, -1, 1, 3, 5};
        System.out.println(getNumSameAsIndex(target));
    }
    public int getNumSameAsIndex(int[] target) {
        if (target == null) {
            throw new NullPointerException();
        }
        int left=0;
        int right=target.length-1;

        while (left <= right) {
            int middle=left+(right-left)/2;
            if (target[middle] == middle) {
                return middle;
            }
            if (target[middle] < middle) {
                left = middle + 1;
            } else {
                right=middle-1;
            }
        }
        return -1;
    }

}
