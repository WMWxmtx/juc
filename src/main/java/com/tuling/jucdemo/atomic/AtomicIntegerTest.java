package com.tuling.jucdemo.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Fox
 */
public class AtomicIntegerTest {

    static AtomicInteger sum = new AtomicInteger(0);
    static AtomicInteger sum1 = new AtomicInteger(0);

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    // 原子自增  CAS
                    //sum.incrementAndGet();
                    int a = sum1.getAndAdd(1);
                    //count++;
                    //System.out.println(sum.get()+"这是新值");
                    System.out.println(sum1.get()+"这是sum1");
                    System.out.println(a+"这是旧值");
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(sum.get());
        System.out.println(sum.get()+"这是新值");
        System.out.println(sum1.get()+"这是旧值");

    }

}
