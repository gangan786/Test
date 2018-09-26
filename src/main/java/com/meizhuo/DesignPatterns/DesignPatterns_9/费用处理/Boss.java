package com.meizhuo.DesignPatterns.DesignPatterns_9.费用处理;

public class Boss extends Leader {
    @Override
    protected void handle(int money) {
        System.out.println("老板处理了"+money+"元请求");
    }

    @Override
    protected int limit() {
        return 100000;
    }
}
