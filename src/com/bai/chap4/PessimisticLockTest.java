package com.bai.chap4;

import org.springframework.util.StopWatch;

/**
 * author:留白
 * create_by:2021/3/10 10:21
 * desc: java 悲观锁demo
 */
public class PessimisticLockTest {

    public static Integer i = new Integer(0);
    public static Object obj = new Object();//用于锁对象

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();//spring的计时小工具
        watch.start();
        for (int ac = 0; ac<20 ; ac++){
            Thread t1 = new Thread(){
                public void run(){
                    for (int ac2=0;ac2<10000;ac2++){
                        synchronized (obj){//锁只能锁对象，不能锁值类型,所以需要另外新建oj对象
                            i = i +1;
                            Thread.yield();//降低当前线程的优先级
                        }
                    }
                    System.out.println("i=" + i);
                    //输出时耗
                    if (i == 200000) {
                        watch.stop();
                        System.out.println("耗时:" + watch.getTotalTimeSeconds());
                    }
                }
            };
            t1.start();
        }

    }


}
