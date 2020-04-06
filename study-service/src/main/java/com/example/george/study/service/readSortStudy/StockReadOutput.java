package com.example.george.study.service.readSortStudy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author George
 * @date 2020/4/4 下午9:40
 */
@Component
public class StockReadOutput {
    @Autowired
    TxtRead txtRead;
    private final static String INPUT = "/Users/george/coding/github/study/study-service/src/test/resource/ali.txt";
    private final static String OUTPUT = "/Users/george/test.xls";


    public void process(){
        try{
            String input = txtRead.read(INPUT);
            input = input.substring(input.indexOf("{"),input.lastIndexOf("}")+1);
            JSONObject object = JSON.parseObject(input);
            List<String> inputData = object.getJSONObject("data").getJSONArray("klines").toJavaList(String.class);
            List<List<String>> data = new LinkedList();
            inputData.forEach(item->{
                String[] items = item.split(",");
                List<String> list = Arrays.asList(items);
                data.add(list);
            });
            File file = new File(OUTPUT);
            boolean name = file.getName().endsWith("xlsx");
            Workbook workbook = getWorkbook(file);
            write(data,workbook);
            System.out.println("123");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void write(List<List<String>> data,Workbook workbook){
        try (OutputStream outputStream = new FileOutputStream(OUTPUT)) {

            Sheet sheet = workbook.getSheetAt(0);
            int rowNumber = sheet.getLastRowNum();    // 第一行从0开始算
            // 删除原有数数据
            System.out.println("原始数据总行数，除属性列：" + rowNumber);
            for (int i = 0; i <= rowNumber; i++) {
                Row row = sheet.getRow(i);
                sheet.removeRow(row);
            }
            //写数据
            for(int j =0;j<data.size();j++){
                List<String> columns = data.get(j);
                Row row = sheet.createRow(j);
                for(int k =0;j<columns.size();k++){
                    Cell cell = row.createCell(k);
                    cell.setCellValue(columns.get(k));
                }
            }
            // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Workbook getWorkbook(File file){
        try(InputStream in = new FileInputStream(file.getAbsolutePath())){
            POIFSFileSystem fs = new POIFSFileSystem(in);
            Workbook workbook = new HSSFWorkbook(fs);
            return workbook;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
