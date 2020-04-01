package com.example.george.study.service.threadAndAsync;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author George
 * @date 2020/3/21 下午9:37
 */
@Configuration
@EnableAsync
public class ConfigThread {

    @Bean
    public TaskExecutor taskExecutor() throws Exception{
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //最大线程池
        executor.setMaxPoolSize(10);
        //核心线程数
        executor.setCorePoolSize(5);
        //队列容量
        executor.setQueueCapacity(20);
        //线程的活跃时间(秒)
        executor.setKeepAliveSeconds(60);
        //设置线程的名称
        executor.setThreadNamePrefix("GeorgeStudy——");
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //所有任务结束后关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;

    }
}
