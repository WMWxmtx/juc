package com.tuling.jucdemo.sync;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import static org.openjdk.jol.info.ClassLayout.*;

/**
 * @author  Fox
 *
 * 关闭指针压缩（-XX:-UseCompressedOops）
 */
@Slf4j
public class ObjectTest {

    public static void main(String[] args) throws InterruptedException {
        //jvm延迟偏向
        log.debug(parseInstance(new Object()).toPrintable());

        Thread.sleep(5000);
        Object obj = new Object();
        //Object obj = new Integer[4];
        //obj.hashCode();
        //查看对象内部信息
        //System.out.println(parseInstance(obj).toPrintable());

//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"开始执行"+"\n"+ parseInstance(obj).toPrintable());
//            synchronized (obj){
//                System.out.println(Thread.currentThread().getName()+"获取锁\n"+ parseInstance(obj).toPrintable());
//                //System.out.println(Thread.currentThread().getName()+"\n"+ parseInstance(ObjectTest.class).toPrintable()+"ObjectTest");
//            }
//            System.out.println(Thread.currentThread().getName()+"释放锁\n"+ parseInstance(obj).toPrintable());
//
//             //jvm 优化
////            try {
////                Thread.sleep(100000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//
//        },"Thread1").start();


        //Thread.sleep(1000);

        new Thread(()->{
            log.debug(Thread.currentThread().getName()+"开始执行"+"\n"+ parseInstance(obj).toPrintable());
            synchronized (obj){
                log.debug(Thread.currentThread().getName()+"获取锁\n"+ parseInstance(obj).toPrintable());
            }
            log.debug(Thread.currentThread().getName()+"释放锁\n"+ parseInstance(obj).toPrintable());

        },"Thread1").start();
        Thread.sleep(2000);
        new Thread(()->{
            log.debug(Thread.currentThread().getName()+"开始执行"+"\n"+ parseInstance(obj).toPrintable());
            synchronized (obj){
                log.debug(Thread.currentThread().getName()+"获取锁\n"+ parseInstance(obj).toPrintable());
            }
            log.debug(Thread.currentThread().getName()+"释放锁\n"+ parseInstance(obj).toPrintable());

        },"Thread2").start();

        Thread.sleep(5000);
        log.debug(ClassLayout.parseInstance(obj).toPrintable());
    }
}

class Test{
    private boolean flag;
    private long  p;
}
