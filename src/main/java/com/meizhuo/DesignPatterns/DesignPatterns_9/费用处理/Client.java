package com.meizhuo.DesignPatterns.DesignPatterns_9.费用处理;

public class Client {
    public static void main(String[] args) {

        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss = new Boss();

        groupLeader.nextLeader = director;
        director.nextLeader = manager;
        manager.nextLeader = boss;

        groupLeader.handleRequest(100);
        groupLeader.handleRequest(8000);
        groupLeader.handleRequest(12000);
        groupLeader.handleRequest(1234567);


    }
}
