package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No5
 * @Description 时间级别为O(n)的替换字符串中空格
 * @Date 2019/6/22 17:40
 * @Created by Gangan
 */
public class No5 {

    public char[] replaceBlank(char[] target) {
        char point = ' ';
        char end = '\0';
        int oldLength = 0;
        int newLength = 0;

        int numBlank = 0;

        for (int i = 0; i < target.length; i++) {
            if (target[i] == point) {
                numBlank++;
            }
            if (target[i] != end) {
                oldLength++;
            } else if (target[i] == end) {
                break;
            }
        }

        newLength = oldLength + numBlank * 2;

        int curOldTail = oldLength;
        int curNewHead = newLength;

        while (curNewHead != curOldTail) {
            if (target[curOldTail] != point) {
                target[curNewHead] = target[curOldTail];
                curNewHead--;
                curOldTail--;
            } else {
                target[curNewHead--] = '0';
                target[curNewHead--] = '2';
                target[curNewHead--] = '%';
                curOldTail--;
            }
        }

        return target;

    }

    @Test
    public void test() {
        char[] test = {'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'e', 'p', 'p', 'y', '\0', '-', '-', '-', '-', '-', '-', '-'};
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : replaceBlank(test)) {
            if (c != '-' && c != '\0') {
                stringBuilder.append(c);
            }
        }
        System.out.println("转化之后为：" + stringBuilder);
    }

}
