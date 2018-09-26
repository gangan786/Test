package com.meizhuo.CrazyJava.Exception;

import com.meizhuo.CrazyJava.OutBase;

import java.io.*;

class Wolf implements Serializable {
    private String name;

    public Wolf(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == Wolf.class) {
            Wolf wolf = (Wolf) obj;
            return wolf.name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class CloseResource {
    public static void main(String[] args)  {
        Wolf wolf = new Wolf("黄虚伪");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        //创建对象输出流
        try {
            oos = new ObjectOutputStream(new FileOutputStream("a.bin"));
            //创建对象输入流
            ois = new ObjectInputStream(new FileInputStream("a.bin"));
            //序列化输出对象
            oos.writeObject(wolf);
            oos.flush();
            //反序列化恢复java对象
            Wolf wolf1=(Wolf) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //回收资源
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
