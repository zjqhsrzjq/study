package com.example.george.study.service.readSortStudy;

import com.example.george.study.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author George
 * @date 2020/4/4 下午9:55
 */
public class StockTest extends BaseServiceTest{
    @Autowired
    StockReadOutput stockReadOutput;

    @Test
    public void test()throws Exception{
        stockReadOutput.process();
    }

}
