package com.example.george.study.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestServiceApplication.class)
public abstract class BaseServiceTest {

    @Before
    public void before(){

    }
}

