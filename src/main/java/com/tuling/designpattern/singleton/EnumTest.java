package com.tuling.designpattern.singleton;

public class EnumTest {
    public static void main(String[] args) {

    }

}

 enum Resource{
    INSTANCE;
    private String a ="1";

    private Resource() {
    }
    public Resource getInstance() {

        return INSTANCE;
    }


}
