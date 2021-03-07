package com.bai.chap3;

/**
 * author:留白
 * create_by:2021/3/7 22:11
 * desc:
 */
public class Container {

    public Hamburger[] array = new Hamburger[6];

    public int index = 0;

    /**
     * 像容器中添加汉堡
     */
    public synchronized void push(Hamburger hamburger){
        while (index==array.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        array[index] = hamburger;
        index++;
        System.out.println("生产了一个汉堡"+hamburger.getId());
    }

    /**
     * 从容器中取出汉堡
     * @return
     */
    public synchronized Hamburger pop(){
        while (index==0){
            //当前线程暂停
            //让正在访问当前资源的线程暂停
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //唤醒之前暂停的线程
        this.notify();
        index--;
        System.out.println("消费了一个汉堡"+array[index].getId());
        return array[index];
    }

}
