package com.meizhuo.algorithm;

import java.util.HashMap;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.leetcode
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/20 21:47
 * @UpdateUser:
 * @UpdateDate: 2018/10/20 21:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Test {

    /**
     * https://leetcode-cn.com/articles/two-sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] targets = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (nums[j] == second) {
                        targets[0] = i;
                        targets[1] = j;
                        break;
                    }
                }
            }
        }

        return targets;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int comp = target - nums[j];
            //该判断的第二个条件是防止数组元素重复
            if (map.containsKey(comp) && !map.get(comp).equals(j)) {
                return new int[]{j, map.get(comp)};
            }
        }
        throw new IllegalArgumentException("no digital like that");
    }

    @org.junit.Test
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp=target-nums[i];
            if (map.containsKey(comp)){
                return new int[]{i,map.get(comp)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no digital like that");
    }

}
