package com.tuling.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
         InnerClassSingleton instance = InnerClassSingleton.getInstance();
         Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
         declaredConstructor.setAccessible(true);
        Class<?>[] declaredClasses = InnerClassSingleton.class.getDeclaredClasses();
        Field lazySingleton =  declaredClasses[0].getDeclaredField("instance");
        lazySingleton.setAccessible(true);
        lazySingleton.set(instance,null);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();

        System.out.println(innerClassSingleton == instance);
        System.out.println(instance1);
    }
}

class InnerClassSingleton {

    private static class InnerClassHolder {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {

        if (InnerClassHolder.instance != null) {
            throw new RuntimeException(" 单例不允许多个实例 ");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

}