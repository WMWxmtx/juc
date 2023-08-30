package com.tuling.designpattern.factory.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

//测试类
public class Factory {
    public static void main(String[] args) {
        Collection collection = new ArrayList<String>();
        collection.iterator().next();


        ProductFactory productFactory = new ConcreteProductA();
        productFactory.getProduct().method1();
    }
}

//抽象工厂（也可以是接口）
//符合单一职责原则和开闭原则
//定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method 使得一个类的实例化延迟到子类
abstract class ProductFactory {
    abstract Product createProduct();
    Product getProduct(){
        Product result = createProduct();
        return result;
    }
}

//具体工厂实现
 class ConcreteProductA extends ProductFactory {
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

//具体工厂实现1
 class ConcreteProductA1 extends ProductFactory {
    @Override
    Product createProduct() {
        return new ProductA1();
    }
}

//产品接口
 interface Product {
    void method1();
}

//产品实现1
 class ProductA implements Product{
    @Override
    public void method1() {
        System.out.println( "ProductA.method1 executed. " );
    }
}

//产品实现2
 class ProductA1 implements Product{
    @Override
    public void method1() {
        System.out.println( "ProductA.method1 executed. " );
    }
}



