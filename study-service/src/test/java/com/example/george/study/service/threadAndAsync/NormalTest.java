package com.example.george.study.service.threadAndAsync;

import com.example.george.study.service.BaseServiceTest;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author George
 * @date 2020/3/21 下午10:16
 */
public class NormalTest extends BaseServiceTest {
    @Autowired
    ThreadMethod threadMethod;

    @Test
    public void test1(){
        for(int i=1;i<5;i++){
            threadMethod.testDelay1();
            System.out.println("test1"+i);
        }
    }

    @Test
    public void test2(){
        for(int i=1;i<5;i++){
            threadMethod.testDelay2();
            System.out.println("test2"+i);
        }
    }

    @Test
    public void test3(){

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("study——schedule——pool").daemon(true).build());
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("George");
        },10,10,TimeUnit.SECONDS);

    }
}
