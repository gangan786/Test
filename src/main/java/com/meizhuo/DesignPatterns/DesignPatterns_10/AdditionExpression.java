package com.meizhuo.DesignPatterns.DesignPatterns_10;

public class AdditionExpression extends OperatorExpression {
    public AdditionExpression(ArithmeticExpression ep1, ArithmeticExpression ep2) {
        super(ep1, ep2);
    }

    @Override
    public int interpret() {
        return ep1.interpret()+ep2.interpret();
    }
}
