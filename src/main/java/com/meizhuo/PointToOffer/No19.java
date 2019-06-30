package com.meizhuo.PointToOffer;

/**
 * @Classname No19
 * @Description 正则表达式匹配
 * @Date 2019/6/30 14:56
 * @Created by Gangan
 */
public class No19 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    //构造递归函数
    public boolean matchCore(char[] str, int s, char[] pattern, int p) {
        if (str.length <= s && pattern.length <= p) {
            //字符串和模式串都匹配完了
            return true;
        }

        if (str.length > s && pattern.length <= p) {
            //模式串完了，字符串还有
            return false;

        }

        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            //当模式串的下一个字符是'*'的情况
            if (str.length <= s) {
                //当字符串匹配完了的情况，模式串直接跳到'*'后面}
                return matchCore(str, s, pattern, p + 2);
            } else {
                if (str[s] == pattern[p] || pattern[p] == '.') {
                    //当前位置匹配，移动到下一个字符

                    return matchCore(str, s, pattern, p + 2)
                            || matchCore(str, s + 1, pattern, p)
                            || matchCore(str, s + 1, pattern, p + 1);

                } else {        //如果当前位置不匹配，只能选择模式串直接跳到'*'后面
                    return matchCore(str, s, pattern, p + 2);
                }
            }
        }
        //当模式串的下一个字符不是'*'的时候
        if (str.length <= s) {
            return false;
            //字符串完，模式串还有的情况}
        } else {
            //字符串和模式串两者都有
            if (str[s] == pattern[p] || pattern[p] == '.') {
                return matchCore(str, s + 1, pattern, p + 1);
            }
        }
        return false;
    }
}
