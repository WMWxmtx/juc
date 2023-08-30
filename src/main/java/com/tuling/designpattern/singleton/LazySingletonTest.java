package com.tuling.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//懒汉模式
// 延迟加载， 只有在真正使用的时候，才开始实例化。
public class LazySingletonTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Object lazySingleton =  new Object();
        Class<LazySingleton> lazySingletonClass = LazySingleton.class;
        Constructor<LazySingleton> declaredConstructor = lazySingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Field flag = LazySingleton.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(lazySingleton,false);
        LazySingleton instance =declaredConstructor.newInstance();
        LazySingleton lazySingleton1 =LazySingleton.getInstance();
        System.out.println(instance);
        System.out.println(lazySingleton1);

//        Field lazySingleton = LazySingleton.class.getDeclaredField("lazySingleton");
//        lazySingleton.setAccessible(true);
//        lazySingleton.set(instance,null);
    }
}
class LazySingleton{
    public  volatile  static LazySingleton lazySingleton;//加volatile保证指令不重排序
    public   static Boolean flag = true;
    private LazySingleton(){
        if (flag){
            throw new RuntimeException("不允许反射");
        }
        if (lazySingleton!=null){
            throw new RuntimeException("单例已存在");
        }
    }
    //双重检测加锁防止线程不安全
    public static LazySingleton getInstance() {
        if (lazySingleton==null){
            synchronized (LazySingleton.class){
                if (lazySingleton==null){
                    flag =false;
                    lazySingleton =new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}

