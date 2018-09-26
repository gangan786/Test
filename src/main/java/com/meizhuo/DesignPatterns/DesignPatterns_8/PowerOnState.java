package com.meizhuo.DesignPatterns.DesignPatterns_8;

/*
开机状态
* */

public class PowerOnState implements TVState {
    @Override
    public void nextChannel() {
        System.out.println("下一个节目");
    }

    @Override
    public void prevChannel() {
        System.out.println("上一个节目");
    }

    @Override
    public void turnUp() {
        System.out.println("调大音量");
    }

    @Override
    public void turnDown() {
        System.out.println("调小音量");
    }
}
