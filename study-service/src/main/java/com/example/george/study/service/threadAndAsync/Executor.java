package com.example.george.study.service.threadAndAsync;

/*
 * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 说明：Executors各个方法的弊端：
 1）newFixedThreadPool和newSingleThreadExecutor:主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
 2）newCachedThreadPool和newScheduledThreadPool:主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM
 */

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author George
 * @date 2020/3/21 下午9:35
 */
@Component
public class Executor {

    @Async("taskExecutor")
    public void test(AtomicInteger integer){
        int num =1;
        while(integer.get()>0){
            integer.decrementAndGet();
            num++;
        }
        System.out.println(num);
    }
}
