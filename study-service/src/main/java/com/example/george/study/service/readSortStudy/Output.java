package com.example.george.study.service.readSortStudy;

import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author George
 * @date 2020/4/4 下午6:37
 */
@Component
public class Output {

    public void wireTxt(byte[] content,String filePath) {
        try(OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeExcel(List list, int columnCount, String filePath){

    }
}
