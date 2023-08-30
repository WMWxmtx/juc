package com.tuling.designpattern.factory.simpleFactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        ProductSimpleFactory factory =new ProductSimpleFactory();
        Product product = factory.getObject("1");
        product.say();
    }

}
class ProductSimpleFactory {
    private Product createProduct(String type){
        return SimpleFactory.createProdcut(type);
    }
    Product getObject(String type){
        return createProduct(type);
    }
}

//方法具体实现
class SimpleFactory {
    public static Product createProdcut(String type) {
        if (type.equals("0")) {
            return new ProductA();
        } else if (type.equals("1")) {
            return new ProductA1();
        } else {
            return null;
        }
    }

}
//产品接口
interface Product {
    void say();
}

//产品实现1
class ProductA implements Product{
    @Override
    public void say() {
        System.out.println("A");
    }
}

//产品实现2
class ProductA1 implements Product{
    @Override
    public void say() {
        System.out.println("A1");
    }
}

