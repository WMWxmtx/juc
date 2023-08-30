package com.tuling.jucdemo.test;

import java.io.Serializable;

//定义接口
interface ILike {
    void lambda();
}
//正常外部类实现接口
class LIke implements ILike, Serializable {

    @Override
    public void lambda() {
        System.out.println("lambda1----正常外部类实现接口");
    }
}


public class LambdaTest {
    //静态内部类实现接口
    static class Like1 implements ILike {
        @Override
        public void lambda() {
            System.out.println("lambda2-----静态内部类实现接口");
        }
    }
    //非静态内部类在外部类的静态方法中必须通过外部类的实例创建内部类的实例。
    //非静态内部类在外部类以外的所有方法中，都必须通过外部类的实例创建内部类的实例。
    //内部非静态方法可以直接创建内部类
    class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("lambda3---非静态内部类实现接口");
        }
    }

    public static void main(String[] args) {
        ILike like = new LIke();
        like.lambda();
        like = new Like1();
        like.lambda();
        like = new LambdaTest().new Like2();
        like.lambda();
        //局部内部类实现接口
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("lambda4---局部内部类实现接口");
            }
        }
        like = new Like3();
        like.lambda();
        //匿名内部类实现接口
        new ILike() {
            @Override
            public void lambda() {
                System.out.println("lambda5---匿名内部类实现接口");
            }
        }.lambda();

        //lambda实现接口
        like =()->{
            System.out.println("lambda6---lambda实现接口");
        };
        like.lambda();
    }
}

class aaa{
    private static void aaaa(){
        ILike like =null;
        like= new LambdaTest().new Like2();//非静态内部类

        like = new LambdaTest.Like1();//静态内部类
    }
}

