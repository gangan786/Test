package com.meizhuo.DesignPatterns.DesignPatterns_7;

public class BusStrategy implements CalculateStrategy {
    @Override
    public int calculatePrice(int km) {
        //这里进行具体的算法计算得到价钱并返回
        return km;
    }
}
