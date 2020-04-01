package com.example.george.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.george.study.service.factory.normal.TestFactory;
import com.example.george.study.service.threadAndAsync.ThreadMethod;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestFactory testFactoryManager;
    @Autowired
    ThreadMethod threadMethod;

    @RequestMapping("factory/{num}")
    public String factory(@PathVariable Integer num){

        return "result:"+ JSONObject.toJSONString(testFactoryManager.getTest(num));
    }

    @RequestMapping("delay/{num}")
    public String delay(@PathVariable Integer num){
        for(int i=1;i<num;i++){
            threadMethod.testDelay1();
            System.out.println("test1:"+i);
        }
        for(int i=1;i<num;i++){
            threadMethod.testDelay2();
            System.out.println("test2:"+i);
        }

        return "Finished";
    }

    @RequestMapping("schedule")
    public String schedule(){
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("%Test——pool%").daemon(true).build());
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("George");
        },0,10, TimeUnit.SECONDS);

        return "OK";
    }
}


