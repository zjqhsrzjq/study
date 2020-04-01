package com.example.george.study.service.threadAndAsync;

import org.springframework.stereotype.Component;

/**
 * @author George
 * @date 2020/3/21 下午10:05
 */
@Component
public class TestDelay implements Runnable {

    @Override
    public void run() {
        try{
            Thread.sleep(3000L);
            System.out.println(System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
