package com.tuling.jucdemo.test;

import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.json.JsonObjectDecoder;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TestJiJin {

    public static void main(String[] args) {
        ArrayList<JiJInData> jiJInData = new ArrayList<>();
        Random r = new Random();

        for (int i =1 ;i<10 ;i++){
            LocalDate now = LocalDate.now();
            LocalDate yesterday = LocalDate.now().minusDays(1);
            JiJInData data = new JiJInData(now,i+r.nextInt(30),"a"+i,0.0);
            JiJInData data1 = new JiJInData(yesterday,i+r.nextInt(30),"a"+i,0.0);
            jiJInData.add(data);
            jiJInData.add(data1);
        }
        System.out.println(JSON.toJSON(jiJInData).toString());
        ArrayList<JiJInData> jiJInData1 = new ArrayList<>();
        Map<String, List<JiJInData>> collect = jiJInData.stream().collect(Collectors.groupingBy(JiJInData::getCode));
        collect.forEach((k,v)->{
            List<JiJInData> collect1 = v.stream().sorted(Comparator.comparing(JiJInData::getDate)).collect(Collectors.toList());
            int toDayData = collect1.get(0).getIntdata();
            int yesterdayData = collect1.get(1).getIntdata();
            double zhangdie =(toDayData - yesterdayData) *1.0 /yesterdayData;
            JiJInData data =new JiJInData(collect1.get(0).getDate(),toDayData,k,zhangdie);
            jiJInData1.add(data);
        });
        List<JiJInData> collect1 = jiJInData1.stream().sorted(Comparator.comparing(JiJInData::getZhangdie,Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect1).toString());
        List<JiJInData> result = collect1.subList(0,5);
        System.out.println(JSON.toJSON(result).toString());

    }

}
