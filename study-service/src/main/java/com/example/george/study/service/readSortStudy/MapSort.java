package com.example.george.study.service.readSortStudy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSort {

    static class Desc implements Comparator<Map<String,Object>> {

        @Override
        public int compare(Map<String, Object> o1, Map<String, Object> o2) {
            Long num1 = Long.valueOf(o1.get("num").toString());
            Long num2 = Long.valueOf(o1.get("num").toString());
            if(num2!=null){
                return num2.compareTo(num1);
            }
            return 0;
        }
    }

    public void sortJava8(){
        Map map =new HashMap();
        map.put("a",1);
        map.put("b",10);
        map.put("c",8);
        map.put("d",11);

        Stream<Map.Entry<String,Integer>> stream =null;
        Stream<Map.Entry<String,Integer>> stream1 =null;
        //正序
        stream =map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        //逆序
        stream1 =map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        List<Map.Entry<String,Integer>> list =stream.collect(Collectors.toList());
        List<Map.Entry<String,Integer>> list1 = stream1.collect(Collectors.toList());
    }
}
