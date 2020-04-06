package com.example.george.study.service.readSortStudy;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author George
 * @date 2020/3/28 下午8:00
 */
@Component
public class TxtRead {

    public String read(String filePath){
        StringBuilder sb = new StringBuilder();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] bytes = new byte[inputStream.available()];
            while ((inputStream.read(bytes)!=-1)){
                sb.append(new String(bytes));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
