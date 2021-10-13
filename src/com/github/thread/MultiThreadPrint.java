package com.github.thread;

/**
 * 两个线程交替打印1到10
 *
 * @Author: zlzhang0122
 * @Date: 2021/6/28 11:43 下午
 */
public class MultiThreadPrint {
    public static volatile int i = 1;
    public static void main(String[] args){
        final Object o = new Object();

        Runnable r = () -> {
            synchronized (o){
                for(;i<10;){
                    System.out.println(Thread.currentThread().getName() + ": " + i++);
                    try {
                        o.notifyAll();
                        o.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
//                    o.notifyAll();
                }
            }
        };

        Thread t1 = new Thread(r, "thread-1");
        Thread t2 = new Thread(r, "thread-2");
        t2.start();
        t1.start();
    }
}
