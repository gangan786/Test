package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No20
 * @Description 判断字符串是否是属于数字
 * @Date 2019/6/30 15:40
 * @Created by Gangan
 */
public class No20 {

    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        MyInt myInt = new MyInt();
        boolean numeric = scanInteger(str, myInt);
        if (str[myInt.index] == '.') {
            myInt.increaseAndGet();
            numeric = scanUnsignedInteger(str, myInt) || numeric;
        }
        if (myInt.index < str.length &&
                (str[myInt.index] == 'e' || str[myInt.index] == 'E')) {
            myInt.increaseAndGet();
            numeric = numeric && scanInteger(str, myInt);
        }

        return numeric && myInt.index == str.length;
    }

    private boolean scanInteger(char[] str, MyInt myInt) {
        if (str[myInt.index] == '+' || str[myInt.index] == '-') {
            myInt.increaseAndGet();
        }
        return scanUnsignedInteger(str, myInt);
    }

    private boolean scanUnsignedInteger(char[] str, MyInt myInt) {
        int before = myInt.index;
        while (myInt.index != str.length && str[myInt.index] >= '0' && str[myInt.index] <= '9') {
            myInt.increaseAndGet();
        }
        return myInt.index > before;
    }

    class MyInt {
        public int index = 0;

        public int increaseAndGet() {
            return ++index;
        }
    }

    @Test
    public void test() {

        System.out.println(isNumeric("12.9E-8".toCharArray()));
        System.out.println(isNumeric("77.01".toCharArray()));
        System.out.println(isNumeric("0.01".toCharArray()));
        System.out.println(isNumeric("10000.0".toCharArray()));
    }

}
