package com.example.george.study.service.threadAndAsync;

import org.springframework.stereotype.Component;

/**
 * @author George
 * @date 2020/3/21 下午10:14
 */
@Component
public class TestNormal implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
    }
}
