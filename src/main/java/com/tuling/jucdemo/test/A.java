package com.tuling.jucdemo.test;

import java.io.*;

public class A implements Serializable {
    static final long serialVersionUID = 42L;
    private static class InnerClassHolder{
        private static A instance= new A();
 }
    public static A getInstance(){
         return InnerClassHolder.instance;
    }
    private int aa =0;
    private int bb =0;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        A test = new A();
//        String testStr = "abc";
//        test.changeStr(testStr);
//        System.out.println(testStr);
        A instance = InnerClassHolder.instance;
//        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("aaa"));
//        oos.writeObject(instance);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aaa"));
        A o = ((A) ois.readObject());
        System.out.println(instance==o);
    }

}
