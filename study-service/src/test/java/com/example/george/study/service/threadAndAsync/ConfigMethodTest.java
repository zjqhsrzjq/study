package com.example.george.study.service.threadAndAsync;

import com.example.george.study.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author George
 * @date 2020/3/21 下午9:53
 */
public class ConfigMethodTest extends BaseServiceTest{
    @Autowired
    Executor executor;

    @Test
    public void test(){
        AtomicInteger integer =new AtomicInteger(100);
        for(int i=0;i<5;i++){
            executor.test(integer);
        }
        System.out.println("finish");
    }
}
