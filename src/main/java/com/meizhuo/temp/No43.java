package com.meizhuo.temp;

/**
 * @Classname No43
 * @Description TODO
 * @Date 2019/9/16 20:19
 * @Created by Gangan
 */
public class No43 {
        private static volatile boolean flagA = true;
        private static volatile boolean flagB = false;
        private static volatile boolean flagC = false;
        public static void main(String[] args){
            Object lock = new Object();
            Thread a = new Thread(new Runnable(){

                @Override
                public void run(){
                    for(int i = 0;i < 10;){
                        synchronized(lock){
                            if(flagA){
                                System.out.print(Thread.currentThread().getName());
                                flagA = false;
                                flagB = true;
                                flagC = false;
                                i++;
                                lock.notifyAll();
                            }else{
                                try{
                                    lock.wait();
                                }catch(Exception e){

                                }
                            }
                        }
                    }
                }
            },"A");

            Thread b = new Thread(new Runnable(){

                @Override
                public void run(){
                    for(int i = 0;i < 10;){
                        synchronized(lock){
                            if(flagB){
                                System.out.print(Thread.currentThread().getName());
                                flagA = false;
                                flagB = false;
                                flagC = true;
                                i++;
                                lock.notifyAll();
                            }else{
                                try{
                                    lock.wait();
                                }catch(Exception e){

                                }
                            }
                        }
                    }
                }
            },"B");
            Thread c = new Thread(new Runnable(){

                @Override
                public void run(){
                    for(int i = 0;i < 10;){
                        synchronized(lock){
                            if(flagC){
                                System.out.print(Thread.currentThread().getName());
                                flagA = true;
                                flagB = false;
                                flagC = false;
                                i++;
                                lock.notifyAll();
                            }else{
                                try{
                                    lock.wait();
                                }catch(Exception e){

                                }
                            }
                        }
                    }
                }
            },"C");

            a.start();
            b.start();
            c.start();
        }


}
