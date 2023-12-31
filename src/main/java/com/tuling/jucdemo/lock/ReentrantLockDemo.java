package com.tuling.jucdemo.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fox
 * 同步执行
 */
public class ReentrantLockDemo {




    private static final Lock lock = new ReentrantLock();
    //private static TulingLock lock = new TulingLock();
    public  static  int sum = 0;
    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 3; i++) {

            Thread thread = new Thread(()->{
                //加锁
                int a =0;
                lock.lock();
                try {
                    // 临界区代码
                    // TODO 业务逻辑：读写操作不能保证线程安全
                    for (int j = 0; j < 10000; j++) {
                         sum++;

                    }
                } finally {
                    // 解锁
                    lock.unlock();
                    System.out.println();
                }
            });
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println(sum);
    }
}



