package com.bai.chap3;

/**
 * author:留白
 * create_by:2021/3/7 22:09
 * desc:
 */
public class Hamburger {

     private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hamburger(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "id=" + id +
                '}';
    }
}
