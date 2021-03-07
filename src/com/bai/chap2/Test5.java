package com.bai.chap2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:留白
 * create_by:2021/3/7 21:37
 * desc:
 */
public class Test5 {

    public static void main(String[] args) {
        StopLock stopLock = new StopLock();

        Thread t1 = new Thread(()->{
            stopLock.service();
        },"A");
        Thread t2 = new Thread(()->{
            stopLock.service();
        },"B");

        t1.start();
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class StopLock{

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public void service(){
        try {
            reentrantLock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName()+"拿到了锁");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
}
