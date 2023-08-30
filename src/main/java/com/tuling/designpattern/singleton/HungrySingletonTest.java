package com.tuling.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HungrySingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HungrySingleton hungrySingleton1;
        Class<HungrySingleton> lazySingletonClass = HungrySingleton.class;
        Constructor<HungrySingleton> declaredConstructor = lazySingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungrySingleton hungrySingleton = declaredConstructor.newInstance();
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(hungrySingleton==instance);
    }
}

class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {
        if(instance!=null){
            throw new RuntimeException( " 单例不允许多个实例 " );
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}