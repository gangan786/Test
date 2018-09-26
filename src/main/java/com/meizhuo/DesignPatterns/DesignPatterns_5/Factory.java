package com.meizhuo.DesignPatterns.DesignPatterns_5;

public interface Factory {
    <T extends Produce> T createProduce(Class<T> clz);
}
