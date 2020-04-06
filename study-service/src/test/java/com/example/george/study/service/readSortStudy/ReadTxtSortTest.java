package com.example.george.study.service.readSortStudy;

import com.example.george.study.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author George
 * @date 2020/4/7 上午12:02
 */
public class ReadTxtSortTest extends BaseServiceTest{
    @Autowired
    ReadTxtAndSort readTxtAndSort;

    @Test
    public void test(){
        String result = readTxtAndSort.process();
        System.out.println(result);
    }
}
