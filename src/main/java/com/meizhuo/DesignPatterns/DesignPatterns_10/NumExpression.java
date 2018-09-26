package com.meizhuo.DesignPatterns.DesignPatterns_10;

/***
 * 数字解释器，仅仅为了解释数字
 */

public class NumExpression extends ArithmeticExpression {

    private int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpret() {
        return num;
    }
}
