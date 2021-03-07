#生产者消费者模式
在一个生产环境中，生产者和消费在同一时间段内共享同一块缓冲区，生产者负责像缓冲区添加数据，消费者负责从缓冲区取出数据

**汉堡类**
```java
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

    @Override
    public String toString() {
        return "Hamburger{" +
                "id=" + id +
                '}';
    }
}

```