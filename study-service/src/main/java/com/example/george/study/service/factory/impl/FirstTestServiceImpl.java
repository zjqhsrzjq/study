package com.example.george.study.service.factory.impl;

import com.example.george.study.service.factory.TestService;
import com.example.george.study.pojo.vo.TestVO;
import org.springframework.stereotype.Component;


@Component(value = "first")
public class FirstTestServiceImpl implements TestService{

    @Override
    public TestVO say() {
        TestVO testVO =new TestVO();
        testVO.setName("First");
        testVO.setAge(1);
        return testVO;
    }
}
