package com.meizhuo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

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

    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{i, map.get(comp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no digital like that");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @org.junit.Test
    public void testAddTwoNumbers() {
        ListNode node1 = new ListNode(5);


        ListNode node4 = new ListNode(5);


        ListNode listNode = addTwoNumbers(node1, node4);
        System.out.println(listNode);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode(0);
        ListNode firstNode = new ListNode(-1);
        int tag = 0;
        boolean go = false;
        while (l1 != null || l2 != null || go) {
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            int sum = l1.val + l2.val;
            if (go) {
                sum++;
                go = false;
            }
            if (sum >= 10) {
                sum = sum % 10;
                go = true;
            }
            if (tag == 0) {
                currentNode.val = sum;
                firstNode = currentNode;
                tag = 1;
            } else {
                currentNode.next = new ListNode(sum);
                currentNode = currentNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return firstNode;

    }

    @org.junit.Test
    public void testLengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring2("abcdwqdfeghi"));
        //System.out.println(lengthOfLongestSubstring("abcdwqdfeghi"));
    }

    public int lengthOfLongestSubstring(String s) {

        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(128);
        int max = 0;
        int tempCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            char temp = charArray[i];


            if (map.containsKey(temp)) {
                tempCount = map.size();
                if (tempCount > max) {
                    max = tempCount;
                }

                i = map.get(temp);
                map.clear();

            } else {
                map.put(temp, i);
                if (max < map.size()) {
                    max = map.size();
                }
            }

        }

        if (tempCount > max) {
            max = tempCount;
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    @org.junit.Test
    public void testLongestPalindrome() {
        System.out.println(longestPalindrome("ac"));

    }

    public String longestPalindrome(String s) {
        String doubleLong = doubleLong(s);
        String singleLong = singleLong(s);
        if (s.length() == 1) {
            return s;
        }
        if (doubleLong.length() > singleLong.length()) {
            return doubleLong;
        } else {
            return singleLong;
        }
    }

    /**
     * 此算法适合找出最长回文子串个数是双数
     *
     * @param s
     * @return
     */
    public String doubleLong(String s) {
        char[] charArray = s.toCharArray();
        String temp = "";
        String max = "";
        for (int i = 0; i < charArray.length; i++) {
            int left = i;
            int right = i + 1;
            for (int j = 0; ; j++) {
                if (left < 0 || right > charArray.length - 1) {
                    break;
                } else {
                    if (charArray[left] == charArray[right]) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
            temp = s.substring(left + 1, right);
            if (temp.length() > max.length()) {
                max = temp;
            }
        }
        if (max.length() == 0 && !max.equals("")) {
            max = String.valueOf(s.charAt(0));
        }
        if (max.length() == 0 && s.length() > 0) {
            max = String.valueOf(s.charAt(0));
        }
        return max;
    }


    /**
     * 此算法适合找出最长回文子串个数是单数
     *
     * @param s
     * @return
     */
    public String singleLong(String s) {
        char[] charArray = s.toCharArray();
        String temp = "";
        String max = "";
        for (int i = 1; i < charArray.length; i++) {
            int left = i - 1;
            int right = i + 1;
            for (; ; ) {
                if (left < 0 || right > charArray.length - 1) {
                    break;
                } else {
                    if (charArray[left] == charArray[right]) {
                        temp = s.substring(left, right + 1);
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }

            if (temp.length() > max.length()) {
                max = temp;
            }
        }
        if (max.length() == 0 && !max.equals("")) {
            max = String.valueOf(s.charAt(0));
        }
        if (max.length() == 0 && s.length() > 0) {
            max = String.valueOf(s.charAt(0));
        }
        return max;
    }

    @org.junit.Test
    public void testConvert() {
        convert("A", 1);
    }

    public String convert(String s, int numRows) {
        StringBuilder[] queues = new StringBuilder[numRows];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new StringBuilder();
        }

        StringBuilder convert = new StringBuilder();
        int point = 0;
        int queuePoint = 0;
        boolean turn = false;
        while (true) {

            if (point == s.length() || queuePoint >= numRows) {
                break;
            }
            if (numRows==1){
                return s;
            }
            StringBuilder queue = queues[queuePoint];
            queue.append(s.charAt(point));
            point++;

            if (!turn) {
                queuePoint++;
                if (queuePoint == numRows - 1) {
                    turn = true;
                }
            } else {
                queuePoint--;
                if (queuePoint == 0) {
                    turn = false;
                }
            }
        }

        for (StringBuilder queue : queues) {
            convert.append(queue);
        }

        return convert.toString();

    }

}
