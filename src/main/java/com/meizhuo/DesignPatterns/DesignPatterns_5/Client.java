package com.meizhuo.DesignPatterns.DesignPatterns_5;

public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcrtetFactory();
        ConcreteProduceA A = factory.createProduce(ConcreteProduceA.class);
        A.method();
    }
}
