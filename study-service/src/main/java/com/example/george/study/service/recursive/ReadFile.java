package com.example.george.study.service.recursive;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author George
 * @date 2020/4/1 上午1:15
 */
@Component
public class ReadFile {

    public String toString(String path){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line= br.readLine())!=null){
                sb.append(line);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
