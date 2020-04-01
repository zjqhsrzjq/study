package com.example.george.study.service.threadAndAsync;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author George
 * @date 2020/3/21 下午9:59
 */
@Component
public class ThreadMethod {
    @Autowired
    TestDelay testDelay;
    @Autowired
    TestNormal testNormal;

    public void testDelay1(){
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("George——pool").build();

        ExecutorService pool = new ThreadPoolExecutor(5,200,10L
                , TimeUnit.SECONDS,new LinkedBlockingDeque<>(20),threadFactory, new ThreadPoolExecutor.AbortPolicy());
        pool.execute(testDelay);
        pool.shutdown();
    }

    public void testDelay2(){
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5,new BasicThreadFactory
                .Builder().namingPattern("George——pool").daemon(true).build());
        //自带延迟
        executorService.schedule(testNormal,5L,TimeUnit.SECONDS);
//        executorService.execute(testDelay);
    }

}
