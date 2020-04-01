package com.example.george.study.service.factory.normal;

import com.example.george.study.common.enums.TestFactoryType;
import com.example.george.study.service.factory.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestFactory {

    @Autowired
    private Map<String,TestService> testService = new HashMap<>();

    public TestService getTest(Integer type){
        if(TestFactoryType.getDesc(type) != null){
            return this.testService.get(TestFactoryType.getDesc(type));
        }
        return null;
    }

}
