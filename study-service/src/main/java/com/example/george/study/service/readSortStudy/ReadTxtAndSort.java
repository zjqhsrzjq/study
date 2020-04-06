package com.example.george.study.service.readSortStudy;

import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author George
 * @date 2020/3/28 下午7:59
 */
@Component
public class ReadTxtAndSort {
   final static String filePath ="/Users/george/coding/study/study-service/src/test/resource/data.txt";

    public String result(){
        StringBuilder sb = new StringBuilder();
        try{
            //读文档
            Map<String,Integer> map =new HashMap<>();
            String filePath ="/Users/george/coding/study/study-service/src/test/resource/data.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine())!=null)
            {
                if(map.containsKey(line)){
                    map.put(line,map.get(line)+1);
                }else {
                    map.put(line,1);
                }
            }
            br.close();
            //排序
            Stream<Map.Entry<String,Integer>> stream =
                    map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
            List<Map.Entry<String,Integer>> list =stream.collect(Collectors.toList());
            if (list.size() > 10) {
                list = list.subList(0, 10);
            }
            //内容转String
            list.forEach(item->{
                sb.append(item.getKey()).append(":").append(item.getValue()).append("\n");
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String process(){
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map =new HashMap<>();
        try{
            String[] data = readTxt().split("\n");
            for(String line : data){
                if(map.containsKey(line)){
                    map.put(line,map.get(line)+1);
                }else {
                    map.put(line,1);
                }
            }
            //排序
            Stream<Map.Entry<String,Integer>> stream =
                    map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
            List<Map.Entry<String,Integer>> list =stream.collect(Collectors.toList());
            if (list.size() > 10) {
                list = list.subList(0, 10);
            }
            //内容转String
            list.forEach(item->{
                sb.append(item.getKey()).append(":").append(item.getValue()).append("\n");
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String readTxt(){
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] bytes = new byte[inputStream.available()];
            if ((inputStream.read(bytes)!=-1)) {
                return new String(bytes);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
