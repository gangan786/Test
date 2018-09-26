package com.meizhuo.DesignPatterns.DesignPatterns_7;

public class TranficCalculator {

    CalculateStrategy calculateStrategy = null;

    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public int getPrice(int km) {
        if (calculateStrategy != null) {
            return calculateStrategy.calculatePrice(km);
        } else return -1;

    }

    public static void main(String[] args) {
        TranficCalculator te = new TranficCalculator();
        te.setCalculateStrategy(new BusStrategy());
        System.out.println("公交出行的价格为：" + te.getPrice(3));
        te.setCalculateStrategy(new SubwayStrategy());
        System.out.println("地铁出行的价格为：" + te.getPrice(4));

    }

}
