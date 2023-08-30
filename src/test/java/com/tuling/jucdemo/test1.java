package com.tuling.jucdemo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @Author 王明伟
 * @create 2023-04-11 22:52
 */
public class test1 {

    public static void main(String[] args) {
        //所有的表
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        //数据表中存在的表
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(7);
        list2.add(6);

        List<Integer> complement1 = list1.stream()
                .filter(element -> !list2.contains(element))
                .collect(Collectors.toList());

        List<Integer> complement2 = list2.stream()
                .filter(element -> !list1.contains(element))
                .collect(Collectors.toList());

        System.out.println("需要添加的表: " + complement1);
        System.out.println("需要删除的表: " + complement2);
    }
}
