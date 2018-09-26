package com.meizhuo.DesignPatterns.DesignPatterns_4;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        WordDocument originDoc=new WordDocument();
        originDoc.setmText("这是一篇蛋疼的吐槽");
        originDoc.addImage("第一张");
        originDoc.addImage("第二张");
        originDoc.addImage("第三张");
        originDoc.addImage("第四张");
        originDoc.showDocument();

        WordDocument doc2=originDoc.clone();//以原始文档为原型，拷贝一份副本
        doc2.showDocument();

        doc2.setmText("修改后的蛋疼");//修改文档副本，不会影响原始文档
        doc2.addImage("在副本中添加");
        doc2.showDocument();

        originDoc.showDocument();

    }
}
