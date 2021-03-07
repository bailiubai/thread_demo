package com.bai.chap2;

import java.util.concurrent.TimeUnit;

/**
 * author:留白
 * create_by:2021/3/7 21:33
 * desc:
 */
public class Test4 {

    public static void main(String[] args) {

        A a = new A();
        new Thread(()->{
            a.test();
        },"A").start();
        new Thread(()->{
            a.test();
        },"B").start();
    }

}

class A{
    private static int num;
    public synchronized void test(){
        System.out.println(Thread.currentThread().getName()+"进来了");
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }
}
