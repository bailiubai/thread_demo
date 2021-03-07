package com.bai.chap2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:留白
 * create_by:2021/3/7 21:16
 * desc:
 */
public class Test3 {

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account,"A").start();
        new Thread(account,"B").start();
    }

}

class Account implements Runnable{

    private ReentrantLock reentrantLock = new ReentrantLock();
    private static int num;

    public void count(){
        //上锁
        reentrantLock.lock();
        num++;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"是当前的第"+num+"用户");
        //解锁
        reentrantLock.unlock();
    }

    @Override
    public void run() {
        count();
    }
}
