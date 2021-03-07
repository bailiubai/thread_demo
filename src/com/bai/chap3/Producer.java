package com.bai.chap3;

import java.util.concurrent.TimeUnit;

/**
 * author:留白
 * create_by:2021/3/7 23:31
 * desc:生产者
 */
public class Producer {

    private Container container = null;

    public Producer(Container container) {
        this.container = container;
    }

    public void product(){
        for (int i = 0;i<30;i++){
            Hamburger hamburger = new Hamburger(i);
            this.container.push(hamburger);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
