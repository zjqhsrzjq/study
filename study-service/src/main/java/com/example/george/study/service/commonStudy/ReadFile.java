package com.example.george.study.service.commonStudy;


import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

    public void readAndSort(){
        File file = new File("data.txt");
        BufferedReader reader =null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            Map<String,Long> map =new HashMap<>();
            //按行读
            while((tempString =reader.readLine()) !=null){
                if(map.containsKey(tempString)){
                    Long num = map.get(tempString);
                    map.put(tempString,num+1);
                }else {
                    map.put(tempString,1L);
                }
            }
            Stream<Map.Entry<String,Long>> stream;
            stream = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
            System.out.println(stream.collect(Collectors.toList()));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader !=null){
                try{
                    reader.close();
                }catch (IOException e){

                }
            }
        }
    }
}
