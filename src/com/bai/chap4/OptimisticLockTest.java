package com.bai.chap4;

import org.springframework.util.StopWatch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:留白
 * create_by:2021/3/10 10:37
 * desc:java 乐观锁demo
 * 乐观锁主要通过CAS（Compare and swap）去现实。
 */
public class OptimisticLockTest {

    public static AtomicInteger j = new AtomicInteger();
    public volatile static int i;

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        for(int ac=0;ac<20;ac++){
            new Thread(){
                @Override
                public void run() {
                    for (int ac2=0;ac2<10000;ac2++){
                        for(;;){//自旋一直执行
                            Integer current = i;
                            Integer next =i+1;
                            if (j.compareAndSet(current,next)){//对比并赋值,注意需要新建一变量current，不能直接使用i
                                i = next;
                                Thread.yield();////降低当前线程的优先级
                                break;
                            }
                        }
                    }
                    System.out.println("i=" + i);
                    if(i==200000){
                        watch.stop();
                        System.out.println("耗时:"+watch.getTotalTimeSeconds());
                    }
                }
            }.start();
        }
    }

}
