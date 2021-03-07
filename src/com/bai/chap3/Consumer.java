package com.bai.chap3;

import java.util.concurrent.TimeUnit;

/**
 * author:留白
 * create_by:2021/3/7 23:30
 * desc:消费者
 */
public class Consumer {

    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    public void consum(){
        for (int i=0;i<30;i++){
            this.container.pop();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
