package com.meizhuo.DesignPatterns.DesignPatterns_8;

public class Client {
    public static void main(String[] args) {
        TVController tvController = new TVController();
        tvController.powerOn();//开机
        tvController.nextChannel();
        tvController.prevChannel();
        tvController.turnUp();
        tvController.turnDown();
        tvController.powerOff();//关机
        tvController.nextChannel();
        tvController.prevChannel();
        tvController.turnUp();
        tvController.turnDown();
    }
}
