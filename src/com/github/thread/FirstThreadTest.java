package com.github.thread;

/**
 * @Author: zlzhang0122
 * @Date: 2020/5/21 8:37 上午
 */
public class FirstThreadTest {
    public static void main(String[] args){
        System.out.println("main start!");

        Thread t = new Thread(() -> {
            try{
                while(true){
                    System.out.println("child is running!");
                    Thread.sleep(100);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        t.start();

        Thread t1 = new Thread(() -> {
            try{
                while(true){
                    System.out.println("child is running!");
                    Thread.sleep(100);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        t1.setDaemon(true);
        t1.start();

        System.out.println("main end!");
    }
}
