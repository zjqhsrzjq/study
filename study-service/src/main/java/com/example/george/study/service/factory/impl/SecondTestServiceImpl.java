package com.example.george.study.service.factory.impl;

import com.example.george.study.service.factory.TestService;
import com.example.george.study.pojo.vo.TestVO;
import org.springframework.stereotype.Component;

@Component(value = "second")
public class SecondTestServiceImpl implements TestService {

    @Override
    public TestVO say() {
        TestVO testVO =new TestVO();
        testVO.setName("Second");
        testVO.setAge(2);
        return testVO;
    }
}
