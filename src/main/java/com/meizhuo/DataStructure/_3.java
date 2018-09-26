package com.meizhuo.DataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _3 {

    public static void main(String[] args) {
//        //将十进制"0123456789"值55转换为26进制“ABCDEFGHIJKLMNOPQRSTUVWXYZ”对应的值，不需要格式化最后输出字符串
//        System.out.println(hex10ToAnly("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 55, 0));
//
//        //将26进制“ABCDEFGHIJKLMNOPQRSTUVWXYZ”字符串值“CD”转换为十进制"0123456789"值55对应的值，不需要格式化最后输出字符串
//        System.out.println(hexAnlyTo10("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "CD"));
        make(3,17);
    }

    /**
     * 将十进制转换为任意进制值
     *
     * @param digths 转换后的进制最小位上，依次出现的字符值，比如26进制"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
     * @param num    将被转换的十进制值
     * @param length 转换到指定字符串后，如果不足length长度位，自动补足最小值，比如26进制"ABCDEFGHIJKLMNOPQRSTUVWXYZ"将在最前补"a"
     * @return
     */
    public static String hex10ToAnly(String digths, int num, int length) {
        StringBuffer str = new StringBuffer("");
        int base = digths.trim().length();
        if (0 == num) {
            str.append(digths.charAt(0));
        } else {
            Stack<Character> s = new Stack<Character>();
            while (num != 0) {
                s.push(digths.charAt(num % base));
                num /= base;
            }
            while (!s.isEmpty()) {
                str.append(s.pop());
            }
        }
        String prefix = "";
        String suffix = str.toString();
        if (length > suffix.length()) {
            for (int count = 0; count < length - suffix.length(); count++) {
                prefix = prefix + digths.charAt(0);
            }
        }
        return prefix + suffix;
    }

    /**
     * 将任意进制转换为十进制值
     *
     * @param digths   转换前的进制最小位上，依次出现的字符值，比如26进制"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
     * @param hexValue 转换前的进制字符串值
     * @return
     */
    public static int hexAnlyTo10(String digths, String hexValue) {
        if (null == hexValue || "".equals(hexValue.trim())) return 0;
        int base = digths.trim().length();

        Map<String, Integer> digthMap = new HashMap<String, Integer>();
        int count = 0;
        for (char item : digths.trim().toCharArray()) {
            digthMap.put("" + item, count);
            count++;
        }
        String str = new StringBuffer(hexValue.trim()).reverse().toString();
        int sum = 0;
        for (int index = 0; index < str.length(); index++) {
            sum = new Double(Math.pow(base, index)).intValue() * digthMap.get("" + str.charAt(index)) + sum;
        }
        return sum;
    }

    /**
     * 将十进制转换为二至九进制之间的任一进制输出
     * @param d 选择要转化的进制
     * @param N 要进行转化的数
     */
    public static void make(int d, int N) {
        int current = N;
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        Stack stack = new Stack<Integer>();
        while (current != 0) {
            result = current % d;
            current = current / d;
            stack.push(result);
        }
        while (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);
    }


}
