package com.example.george.study.service.readSortStudy;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSortStudyTest {

    @Test
    public void test(){
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
        System.out.println(list.toString());
    }

//    @Test
//    public void read(){
//        Map<String,Integer> map =new HashMap<>();
//        try{
//            String filePath ="/Users/george/coding/study/study-service/src/test/resource/data.txt";
//            BufferedReader br = new BufferedReader(new FileReader(filePath));
//            while((br.readLine())!=null){//使用readLine方法，一次读一行
//                String line = br.readLine();
//                if(map.containsKey(line)){
//                    map.put(line,map.get(line)+1);
//                }else {
//                    map.put(line,1);
//                }
//            }
//            br.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @Test
    public void readAndSort(){
        try{
            //读文档
            Map<String,Integer> map =new HashMap<>();
            String filePath ="/Users/george/coding/study/study-service/src/test/resource/data.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line=br.readLine())!=null)
            {
                if(map.containsKey(line)){
                    map.put(line,map.get(line)+1);
                }else {
                    map.put(line,1);
                }
            }
            br.close();
            //排序
            List<Map.Entry<String,Integer>> list =map.entrySet().stream()
                     //逆序
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    //转为list
                    .collect(Collectors.toList());
            if (list.size() > 10) {
                list = list.subList(0, 10);
            }
            //内容转String
            StringBuilder sb = new StringBuilder();
            list.forEach(item->{
                sb.append(item.getKey()).append(":").append(item.getValue()).append("\n");
            });

            System.out.println(sb);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
