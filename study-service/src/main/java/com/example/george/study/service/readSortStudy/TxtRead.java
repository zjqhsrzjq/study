package com.example.george.study.service.readSortStudy;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author George
 * @date 2020/3/28 下午8:00
 */
@Component
public class TxtRead {

    public String read(){
        StringBuilder sb  = new StringBuilder();
        try{
            String filePath ="/Users/george/coding/study/study-service/src/test/resource/data.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while (br.readLine()!=null){
                sb.append(br.readLine()).append("\n");
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  sb.toString();
    }
}
