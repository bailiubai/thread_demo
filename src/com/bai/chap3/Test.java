package com.bai.chap3;

/**
 * author:留白
 * create_by:2021/3/7 23:40
 * desc:
 */
public class Test {

    public static void main(String[] args) {
        Container container = new Container();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        new Thread(()->{
            producer.product();
        }).start();
        new Thread(()->{
            consumer.consum();
        }).start();
    }

}
