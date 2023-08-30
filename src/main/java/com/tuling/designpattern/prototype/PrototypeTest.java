package com.tuling.designpattern.prototype;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("tom", 10, new Sheep("tony", 10, null));
        new StringBuilder();

    }
}

class Sheep implements Cloneable{
    private String name;
    private int age;
    private Sheep friend;

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friend=" + friend +
                '}';
    }

    public Sheep(String name, int age, Sheep friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public Sheep setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Sheep setAge(int age) {
        this.age = age;
        return this;
    }

    public Sheep getFriend() {
        return friend;
    }

    public Sheep setFriend(Sheep friend) {
        this.friend = friend;
        return this;
    }

    @Override
    protected Sheep clone() throws CloneNotSupportedException {
        Sheep sheep = ((Sheep) super.clone());
        if (sheep.friend!=null){
            sheep.friend =  sheep.friend.clone();
        }
        return sheep;
    }
}
