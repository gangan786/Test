package com.meizhuo.DesignPatterns.DesignPatterns_7;

public class SubwayStrategy implements CalculateStrategy {
    @Override
    public int calculatePrice(int km) {
        //这里进行具体的算法计算价钱，并将价钱返回
        return km;
    }
}
