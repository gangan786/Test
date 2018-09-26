package com.meizhuo.DesignPatterns.DesignPatterns_5;

public class ConcrtetFactory implements Factory {

    @Override
    public <T extends Produce> T createProduce(Class<T> clz) {
        Produce produce = null;
        try {
            produce = (Produce) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) produce;
    }
}
