package com.meizhuo.DesignPatterns.DesignPatterns_8;

/*
关机状态
* */
public class PowerOffState implements TVState {
    @Override
    public void nextChannel() {
        System.out.println("请先打开电视机");
    }

    @Override
    public void prevChannel() {
        System.out.println("请先打开电视机");
    }

    @Override
    public void turnUp() {
        System.out.println("请先打开电视机");
    }

    @Override
    public void turnDown() {
        System.out.println("请先打开电视机");
    }
}
