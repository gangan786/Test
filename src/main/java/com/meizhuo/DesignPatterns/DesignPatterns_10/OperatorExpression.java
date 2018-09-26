package com.meizhuo.DesignPatterns.DesignPatterns_10;

/**
 * 运算符号抽象解释器
 * 为所有运算符号解释器共性的提取
 */

public abstract class OperatorExpression extends ArithmeticExpression {

    protected ArithmeticExpression ep1,ep2;

    public OperatorExpression(ArithmeticExpression ep1, ArithmeticExpression ep2) {
        this.ep1 = ep1;
        this.ep2 = ep2;
    }
}
